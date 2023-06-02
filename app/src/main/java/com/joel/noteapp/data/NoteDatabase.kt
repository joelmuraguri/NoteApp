package com.joel.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joel.noteapp.data.models.Note

@Database(entities = [Note::class], exportSchema = false, version = 1)
abstract class NoteDatabase : RoomDatabase(){

    abstract fun noteDao() : NoteDao

}