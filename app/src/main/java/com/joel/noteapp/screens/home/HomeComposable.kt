package com.joel.noteapp.screens.home

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.core.utils.toAction


const val HOME_SCREEN = "home/{action}"
const val HOME_ARGUMENT_KEY = "action"

fun NavGraphBuilder.homeComposable(
    viewModel: HomeViewModel,
    navigateToEditScreen: (taskId: Int) -> Unit,
    navigateToSearchScreen: () -> Unit,
    openDrawer : () -> Unit
    ){

    composable(
        route = HOME_SCREEN,
        arguments = listOf(navArgument(HOME_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){ navBackStackEntry ->

        val action = navBackStackEntry.arguments!!.getString(HOME_ARGUMENT_KEY).toAction()

        var myAction by rememberSaveable { mutableStateOf(Actions.NO_ACTION) }

        LaunchedEffect(key1 = myAction){
            if (action != myAction){
                myAction = action
                viewModel.updateAction(newAction = action)
            }
        }

        val databaseActions = viewModel.action

        HomeScreen(
            navigateToSearch = navigateToSearchScreen,
            viewModel = viewModel,
            action = databaseActions,
            navigateToEditScreen = navigateToEditScreen,
            openDrawer = openDrawer
        )
    }
}