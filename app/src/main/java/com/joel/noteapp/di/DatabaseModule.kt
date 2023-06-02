package com.joel.noteapp.di

import android.app.Application
import androidx.room.Room
import com.joel.noteapp.data.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application) : NoteDatabase{
        return Room.databaseBuilder(
            application,
            NoteDatabase::class.java,
            "NOTE_DATABASE"
        ).build()
    }

}