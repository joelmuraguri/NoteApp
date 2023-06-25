package com.joel.noteapp.screens.editnotes

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.noteapp.data.models.Note
import com.joel.noteapp.data.repos.NotesRepository
import com.joel.noteapp.utils.AppEvents
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: NotesRepository
): ViewModel() {

    var note by mutableStateOf<Note?>(null)
        private set

    var title by mutableStateOf("")
        private set
    var content by mutableStateOf("")
        private set

    private val _appEvent =  Channel<AppEvents>()
    val appEvent = _appEvent.receiveAsFlow()


    fun onEvents(events: EditUiEvents){
        when(events){
            is EditUiEvents.ChangeBackgroundColor -> TODO()
            is EditUiEvents.CreateTag -> TODO()
            is EditUiEvents.OnContentChange -> {
                content = events.contents
            }
            is EditUiEvents.OnTitleChange -> {
                title = events.title
            }
            is EditUiEvents.OpenBottomSheet -> TODO()
            is EditUiEvents.SaveNote -> {
                viewModelScope.launch {
                    if (title.isBlank()){
                        sendAppEvents(AppEvents.ShowSnackBar(
                            message = "Title is Empty!"
                        ))
                        return@launch
                    }
                    repository.addNote(
                        Note(
                            id = note?.id,
                            title = title,
                            content = content
                        )
                    )
                    sendAppEvents(AppEvents.PopBackStack)
                }
            }
        }
    }


    fun sendAppEvents(events: AppEvents){
        viewModelScope.launch {
            _appEvent.send(events)
        }
    }

}

