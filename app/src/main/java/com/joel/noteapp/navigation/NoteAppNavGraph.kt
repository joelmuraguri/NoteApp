package com.joel.noteapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joel.noteapp.screens.editnotes.EditViewModel
import com.joel.noteapp.screens.editnotes.editComposable
import com.joel.noteapp.screens.favourite.favouriteComposable
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.home.HomeViewModel
import com.joel.noteapp.screens.home.homeComposable
import com.joel.noteapp.screens.search.searchComposable
import com.joel.noteapp.screens.settings.settingsComposable

@Composable
fun NoteAppNavGraph(
    navController: NavHostController,
    navigateToSearchScreen: () -> Unit,
    navigateToHome: () -> Unit,
    onAdd: () -> Unit,
    editViewModel: EditViewModel = viewModel(),
    homeViewModel: HomeViewModel = viewModel()

){

    NavHost(navController = navController, startDestination = HOME_SCREEN){
        homeComposable(onAdd = onAdd, navigateToSearch = navigateToSearchScreen, homeViewModel)
        editComposable(navigateToHome = navigateToHome, editViewModel = editViewModel)
        favouriteComposable()
        searchComposable()
        settingsComposable()
    }
}