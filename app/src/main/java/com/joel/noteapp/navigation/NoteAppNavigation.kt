package com.joel.noteapp.navigation

import androidx.navigation.NavHostController
import com.joel.noteapp.screens.editnotes.EDIT_SCREEN
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.search.SEARCH_ROUTE

class NoteAppNavigation(navController: NavHostController){

    val navigateToHomeScreen : () -> Unit = {
        navController.navigate(route = HOME_SCREEN)
    }

    val navigateToSearch : () -> Unit = {
        navController.navigate(route = SEARCH_ROUTE)
    }

    val navigateToEditScreen : () -> Unit = {
        navController.navigate(route = EDIT_SCREEN)
    }



}