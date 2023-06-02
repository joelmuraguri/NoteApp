package com.joel.noteapp.data.repos

import com.joel.noteapp.data.NoteDao
import com.joel.noteapp.data.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class NotesRepositoryImpl(
    private val dao : NoteDao
) : NotesRepository {

    override fun getAllNotes(): Flow<List<Note>> {
        Dispatchers.IO
        return dao.getAllNotes()
    }

    override fun getNoteById(noteId: Int): Flow<Note> {
        return dao.getNoteById(noteId)
    }

    override suspend fun addNote(note: Note) {
        dao.addNote(note)
    }

    override suspend fun updateNote(note: Note) {
        dao.updateNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        dao.deleteNote(note)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }
}