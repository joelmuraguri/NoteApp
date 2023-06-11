package com.joel.noteapp.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.core.utils.RequestState
import com.joel.noteapp.data.models.Note
import com.joel.noteapp.data.repos.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: NotesRepository
) : ViewModel() {

    var action by mutableStateOf(Actions.NO_ACTION)
        private set

    var id by mutableStateOf(0)
        private set

    var title by mutableStateOf("")
        private set

    var contents by mutableStateOf("")
        private set

    val notes = repository.getAllNotes()



    private val _allNotes = MutableStateFlow<RequestState<List<Note>>>(RequestState.Idle)
    val allNotes: StateFlow<RequestState<List<Note>>> = _allNotes

    private fun getAllNotes() {
        _allNotes.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllNotes().collect {
                    _allNotes.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allNotes.value = RequestState.Error(e)
        }
    }

    private fun addNote(){
        viewModelScope.launch(Dispatchers.IO) {
            val note = Note(
                id = id,
                title = title,
                content = contents
            )
            repository.addNote(note)
        }
    }

    private fun updateNote(){
        viewModelScope.launch(Dispatchers.IO) {
            val note = Note(
                id = id,
                title = title,
                content = contents
            )
            repository.updateNote(note)
        }
    }

    private fun deleteNote(){
        viewModelScope.launch(Dispatchers.IO) {
            val note = Note(
                id = id,
                title = title,
                content = contents
            )
            repository.deleteNote(note)
        }
    }

    fun handleDatabaseActions(actions: Actions){
        when(actions){
            Actions.ADD -> { addNote() }
            Actions.UPDATE -> {
                updateNote()
            }
            Actions.DELETE -> {
                deleteNote()
            }
            Actions.UNDO -> {
                addNote()
            }
            else -> {}
        }
    }

    fun updateAction(newAction: Actions) {
        action = newAction
    }

    fun updateTaskFields(selectedNote: Note?) {
        if (selectedNote != null) {
            id = selectedNote.id
            title = selectedNote.title
            contents = selectedNote.content
        } else {
            id = 0
            title = ""
            contents = ""
        }
    }


}