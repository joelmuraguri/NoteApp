package com.joel.noteapp

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joel.noteapp.core.design.components.AppDrawer
import com.joel.noteapp.navigation.NavRoutes
import com.joel.noteapp.navigation.appNavOptionsGraph
import com.joel.noteapp.navigation.drawerRouteGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteApp(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

){

    val context = LocalContext.current

    AppDrawer(
        navController = navController,
        drawerState = drawerState
    ) {
        NavHost(navController = navController, startDestination = NavRoutes.MainRoute.name){
            drawerRouteGraph(drawerState, navController, context)
            appNavOptionsGraph(navController)
        }
    }
}

