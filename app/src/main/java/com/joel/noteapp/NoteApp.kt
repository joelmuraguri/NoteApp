package com.joel.noteapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.joel.noteapp.navigation.NoteAppNavGraph
import com.joel.noteapp.navigation.NoteAppNavigation

@Composable
fun NoteAppSetup() {

    val navController = rememberNavController()

    val navigationActions = remember {
        NoteAppNavigation(navController)
    }

    NoteAppNavGraph(
        navController = navController,
        onAdd = navigationActions.navigateToEditScreen,
        navigateToSearchScreen = navigationActions.navigateToSearch,
        navigateToHome = navigationActions.navigateToHomeScreen
    )
}


