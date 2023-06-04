package com.joel.noteapp.screens.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SEARCH_ROUTE = "home"

fun NavGraphBuilder.searchComposable(){

    composable(route = SEARCH_ROUTE){
        SearchScreen()
    }

}