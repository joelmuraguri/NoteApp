package com.joel.noteapp.screens.editnotes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.data.models.Note
import com.joel.noteapp.data.repos.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: NotesRepository
): ViewModel() {


    var action by mutableStateOf(Actions.NO_ACTION)
        private set

    var id by mutableStateOf(0)
        private set

    var title by mutableStateOf("")
        private set

    var contents by mutableStateOf("")
        private set

    private val _selectedNote: MutableStateFlow<Note?> = MutableStateFlow(null)
    val selectedNote: StateFlow<Note?> = _selectedNote


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

    fun getSelectedNote(noteId: Int) {
        viewModelScope.launch {
            repository.getNoteById(noteId = noteId).collect { note ->
                _selectedNote.value = note
            }
        }
    }

    private fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
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

    fun updateNoteTextFields(note: Note?){
        if (note != null){
            id = note.id
            title = note.title
            contents = note.content
        } else {
            id = 0
            title = ""
            contents = ""
        }
    }

    fun updateTitle(newTitle : String){
        title = newTitle
    }

    fun updateContents(newContents : String){
        title = newContents
    }


    fun validateFields(): Boolean {
        return title.isNotEmpty() && contents.isNotEmpty()
    }

}