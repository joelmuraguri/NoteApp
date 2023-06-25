package com.joel.noteapp.screens.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


const val HOME_SCREEN = "home"

fun NavGraphBuilder.homeComposable(
    onAdd : () -> Unit,
    navigateToSearch : () -> Unit
) {

    composable(
        route = HOME_SCREEN,
    ){
        HomeScreen(
            onAdd = onAdd,
            navigateToSearch = navigateToSearch
        )
    }
}