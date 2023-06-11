package com.joel.noteapp.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joel.noteapp.core.utils.Actions
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
    homeViewModel: HomeViewModel,
    editViewModel: EditViewModel,
    context: Context,
    navigateToEditScreen : (noteId : Int) -> Unit,
    navigateToSearchScreen : () -> Unit,
    navigateToHomeScreen : (Actions) -> Unit,
){

    NavHost(navController = navController, startDestination = HOME_SCREEN){
        homeComposable(
            viewModel = homeViewModel,
            navigateToEditScreen = navigateToEditScreen,
            navigateToSearchScreen = navigateToSearchScreen
        )
        editComposable(
            viewModel = editViewModel,
            navigateToHomeScreen = navigateToHomeScreen,
            context = context,
            navHostController = navController
        )
        favouriteComposable()
        searchComposable()
        settingsComposable()
    }
}