package com.joel.noteapp.screens.favourite

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val FAVOURITE_ROUTE = "favourite"

fun NavGraphBuilder.favouriteComposable(){

    composable(route = FAVOURITE_ROUTE){
        FavouriteScreen()
    }

}