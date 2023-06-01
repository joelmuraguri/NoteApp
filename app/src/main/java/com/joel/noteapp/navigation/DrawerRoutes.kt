package com.joel.noteapp.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.joel.noteapp.screens.editnotes.EditScreen
import com.joel.noteapp.screens.favourite.FavouriteScreen
import com.joel.noteapp.screens.home.HomeScreen
import com.joel.noteapp.screens.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.drawerRouteGraph(drawerState: DrawerState){
    navigation(startDestination = DrawerNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name ){
        composable(route = DrawerNavOption.HomeScreen.name){
            HomeScreen(drawerState)
        }
        composable(route = DrawerNavOption.FavouriteScreen.name){
            FavouriteScreen()
        }
        composable(route = DrawerNavOption.SettingsScreen.name){
            SettingsScreen()
        }
        composable(route = DrawerNavOption.TagScreen.name){
            EditScreen()
        }
    }
}

enum class NavRoutes {
    IntroRoute,
    MainRoute,
}

enum class DrawerNavOption {
    HomeScreen,
    FavouriteScreen,
    TagScreen,
    SettingsScreen,
}