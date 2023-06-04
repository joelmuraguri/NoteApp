package com.joel.noteapp.navigation

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.joel.noteapp.screens.editnotes.EditScreen
import com.joel.noteapp.screens.favourite.FavouriteScreen
import com.joel.noteapp.screens.home.HomeScreen
import com.joel.noteapp.screens.search.SearchScreen
import com.joel.noteapp.screens.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.drawerRouteGraph(drawerState: DrawerState, navController: NavHostController, context: Context){

    navigation(startDestination = DrawerNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name ){
        composable(route = DrawerNavOption.HomeScreen.name){

        }
        composable(route = DrawerNavOption.FavouriteScreen.name){
            FavouriteScreen()
        }
        composable(route = DrawerNavOption.SettingsScreen.name){
            SettingsScreen()
        }
        composable(route = DrawerNavOption.TagScreen.name){
            Toast.makeText(context, "NOT YET CONFIGURED", Toast.LENGTH_SHORT).show()
        }
    }
}

fun NavGraphBuilder.appNavOptionsGraph(navController: NavHostController){
    navigation(startDestination = AppNavOptions.EditScreen.name, route = NavRoutes.AppNavOptionsRoute.name){
        composable(route = AppNavOptions.EditScreen.name){
//            EditScreen(
//                onPopBackStack = {navController.popBackStack()}, navigateToHomeScreen = {})
        }
        composable(route = AppNavOptions.SearchScreen.name){
            SearchScreen()
        }
    }
}



enum class AppNavOptions{
    SearchScreen,
    EditScreen,
}

enum class NavRoutes {
    AppNavOptionsRoute,
    MainRoute,
}

enum class DrawerNavOption {
    HomeScreen,
    FavouriteScreen,
    TagScreen,
    SettingsScreen,
}