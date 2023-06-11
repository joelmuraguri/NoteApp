package com.joel.noteapp.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.screens.favourite.FAVOURITE_ROUTE
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.search.SEARCH_ROUTE
import com.joel.noteapp.screens.settings.SETTINGS_ROUTE

class NoteAppNavigation(navController: NavHostController){

    val navigateToEdit : (Int) -> Unit = { noteId ->
        navController.navigate(route = "edit/$noteId")
    }


    val navigateToHome : (Actions) -> Unit = { actions ->
        navController.navigate(route = "home/${actions}"){
            popUpTo(HOME_SCREEN)
        }
    }


    val navigateToFavourites : () -> Unit = {
        navController.navigate(route = FAVOURITE_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToSettings : () -> Unit = {
        navController.navigate(route = SETTINGS_ROUTE){
            popUpTo(navController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToSearch : () -> Unit = {
        navController.navigate(route = SEARCH_ROUTE)
    }

}