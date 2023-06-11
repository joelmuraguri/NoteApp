package com.joel.noteapp

import android.widget.Toast
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.joel.noteapp.core.design.components.AppNavDrawer
import com.joel.noteapp.navigation.NoteAppNavGraph
import com.joel.noteapp.navigation.NoteAppNavigation
import com.joel.noteapp.screens.editnotes.EditViewModel
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun NoteAppSetup(
    homeViewModel: HomeViewModel,
    editViewModel: EditViewModel,
){

    val context = LocalContext.current

    val navController = rememberNavController()

    val navigationActions = remember {
        NoteAppNavigation(navController)
    }


    NoteAppNavGraph(
        navController = navController,
        homeViewModel = homeViewModel,
        editViewModel = editViewModel,
        context = context,
        navigateToEditScreen = navigationActions.navigateToEdit,
        navigateToSearchScreen = navigationActions.navigateToSearch,
        navigateToHomeScreen = navigationActions.navigateToHome
    )


}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun NoteApp(
//    homeViewModel: HomeViewModel,
//    editViewModel: EditViewModel
//){
//
//    val navController = rememberNavController()
//    val navigationActions = remember(navController) {
//            NoteAppNavigation(navController)
//    }
//
//    val context = LocalContext.current
//
//    val coroutineScope = rememberCoroutineScope()
//
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    val currentRoute = navBackStackEntry?.destination?.route ?: HOME_SCREEN
//
//    ModalNavigationDrawer(
//        drawerContent = {
//            AppNavDrawer(
//                currentRoute = currentRoute,
//                navigateToHome = navigationActions.navigateToHome,
//                navigateToFavourites = navigationActions.navigateToFavourites,
//                navigateToSettings = { /*TODO*/ },
//                navigateToTags = {Toast.makeText(context,"NO TAGS", Toast.LENGTH_SHORT).show() },
//                closeDrawer = { coroutineScope.launch { drawerState.close() } })
//        },
//        drawerState = drawerState
//    ) {
//
//        NoteAppNavGraph(
//            navController = navController,
//            homeViewModel = homeViewModel,
//            editViewModel = editViewModel,
//            context = context,
//            navigateToEditScreen = navigationActions.navigateToEdit,
//            navigateToSearchScreen = navigationActions.navigateToSearch,
//            navigateToHomeScreen = navigationActions.navigateToHome,
//            openDrawer = { coroutineScope.launch { drawerState.open() } }
//        )
//    }
//
//}

