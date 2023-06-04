package com.joel.noteapp.screens.editnotes

import android.content.Context
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joel.noteapp.core.utils.Actions

const val EDIT_SCREEN = "edit/{noteId}"
const val EDIT_ARGUMENT_KEY = "noteId"



fun NavGraphBuilder.editComposable(
    viewModel: EditViewModel,
    navigateToHomeScreen : (Actions) -> Unit,
    context : Context,
    navHostController: NavHostController
){

    composable(
        route = EDIT_SCREEN,
        arguments = listOf(navArgument(EDIT_ARGUMENT_KEY) {
            type = NavType.IntType
        }),
    ){ navBackStackEntry ->

        val noteId = navBackStackEntry.arguments!!.getInt(EDIT_ARGUMENT_KEY)
        LaunchedEffect(key1 = noteId){
            viewModel.getSelectedNote(noteId)
        }

        val selectedNote by viewModel.selectedNote.collectAsState()
        LaunchedEffect(key1 =selectedNote){
            if (selectedNote != null){
                viewModel.updateNoteTextFields(selectedNote)
            }
        }

        EditScreen(
            viewModel = viewModel,
            navigateToHomeScreen = navigateToHomeScreen,
            note = selectedNote,
            context = context,
            onPopBackStack = { navHostController.popBackStack() }
        )
    }

}