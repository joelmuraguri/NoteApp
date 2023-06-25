package com.joel.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joel.noteapp.screens.editnotes.editComposable
import com.joel.noteapp.screens.favourite.favouriteComposable
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.home.homeComposable
import com.joel.noteapp.screens.search.searchComposable
import com.joel.noteapp.screens.settings.settingsComposable

@Composable
fun NoteAppNavGraph(
    navController: NavHostController,
    navigateToSearchScreen: () -> Unit,
    onAdd: () -> Unit,
    onPopBackStack : () -> Unit
){

    NavHost(navController = navController, startDestination = HOME_SCREEN){
        homeComposable(onAdd = onAdd, navigateToSearch = navigateToSearchScreen)
        editComposable(onPopBackStack = onPopBackStack)
        favouriteComposable()
        searchComposable()
        settingsComposable()
    }
}