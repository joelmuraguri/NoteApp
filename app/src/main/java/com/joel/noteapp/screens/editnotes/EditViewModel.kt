package com.joel.noteapp.screens.editnotes

import androidx.lifecycle.ViewModel
import com.joel.noteapp.data.repos.NotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: NotesRepository
): ViewModel() {


}