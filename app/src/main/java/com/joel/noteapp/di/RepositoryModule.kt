package com.joel.noteapp.di

import com.joel.noteapp.data.NoteDatabase
import com.joel.noteapp.data.repos.NotesRepository
import com.joel.noteapp.data.repos.NotesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(database: NoteDatabase) : NotesRepository{
        return NotesRepositoryImpl(database.noteDao())
    }


}