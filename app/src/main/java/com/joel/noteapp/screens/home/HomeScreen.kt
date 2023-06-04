package com.joel.noteapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.joel.noteapp.core.design.components.NoteItem
import com.joel.noteapp.core.design.composables.AddFAB
import com.joel.noteapp.core.design.composables.HomeTopBar
import com.joel.noteapp.core.utils.Actions

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToSearch: () -> Unit,
    viewModel: HomeViewModel,
    action: Actions,
    navigateToEditScreen: (taskId: Int) -> Unit,
    openDrawer : () -> Unit
){

    val notes = viewModel.notes.collectAsState(initial = emptyList())


    LaunchedEffect(key1 = action) {
        viewModel.handleDatabaseActions(actions = action)
    }

    val snackBarHostState = remember { SnackbarHostState() }


    DisplaySnackBar(
        snackBarHostState = snackBarHostState,
        onComplete = { viewModel.updateAction(newAction = it) },
        onUndoClicked = { viewModel.updateAction(newAction = it) },
        taskTitle = viewModel.title,
        action = action
    )

    Scaffold(
        topBar = {
            HomeTopBar(
                openDrawer = openDrawer,
                navigateToSearch = navigateToSearch)
        },
        floatingActionButton = {
            AddFAB(
                onFabClicked = navigateToEditScreen
            )
        },
        snackbarHost = { snackBarHostState }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ){
            items(notes.value){
               NoteItem(
                   navigateToEditScreen = navigateToEditScreen,
                   note = it
               )
            }
        }
    }
}

@Composable
fun DisplaySnackBar(
    snackBarHostState: SnackbarHostState,
    onComplete: (Actions) -> Unit,
    onUndoClicked: (Actions) -> Unit,
    taskTitle: String,
    action: Actions
) {
    LaunchedEffect(key1 = action) {
        if (action != Actions.NO_ACTION) {
            val snackBarResult = snackBarHostState.showSnackbar(
                message = setMessage(action = action, taskTitle = taskTitle),
                actionLabel = setActionLabel(action = action)
            )
            undoDeletedTask(
                action = action,
                snackBarResult = snackBarResult,
                onUndoClicked = onUndoClicked
            )
            onComplete(Actions.NO_ACTION)
        }
    }
}

private fun setMessage(action: Actions, taskTitle: String): String {
    return when (action) {
        Actions.DELETE_ALL -> "All Tasks Removed."
        else -> "${action.name}: $taskTitle"
    }
}

private fun setActionLabel(action: Actions): String {
    return if (action.name == "DELETE") {
        "UNDO"
    } else {
        "OK"
    }
}

private fun undoDeletedTask(
    action: Actions,
    snackBarResult: SnackbarResult,
    onUndoClicked: (Actions) -> Unit
) {
    if (snackBarResult == SnackbarResult.ActionPerformed
        && action == Actions.DELETE
    ) {
        onUndoClicked(Actions.UNDO)
    }
}