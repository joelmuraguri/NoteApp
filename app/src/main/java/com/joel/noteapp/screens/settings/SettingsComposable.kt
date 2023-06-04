package com.joel.noteapp.screens.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SETTINGS_ROUTE = "settings"

fun NavGraphBuilder.settingsComposable(){

    composable(route = SETTINGS_ROUTE){
        SettingsScreen()
    }

}