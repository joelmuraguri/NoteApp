package com.joel.noteapp.data.repos

import com.joel.noteapp.data.models.Note
import kotlinx.coroutines.flow.Flow

interface NotesRepository {

    fun getAllNotes() : Flow<List<Note>>

    fun getNoteById(noteId :Int) : Flow<Note>

    suspend fun addNote(note: Note)

    suspend fun updateNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun deleteAll()
}