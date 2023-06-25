package com.joel.noteapp.screens.editnotes

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val EDIT_SCREEN = "edit"

fun NavGraphBuilder.editComposable(
    onPopBackStack : () -> Unit
){

    composable(
        route = EDIT_SCREEN
    ){
        EditScreen(onPopBackStack = onPopBackStack)
    }

}