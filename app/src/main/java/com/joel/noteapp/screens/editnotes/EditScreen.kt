package com.joel.noteapp.screens.editnotes

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.noteapp.R
import com.joel.noteapp.core.design.composables.NewNoteTopBar
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.utils.AppEvents
import kotlinx.coroutines.flow.collect

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    navigateToHome: () -> Unit,
    editViewModel: EditViewModel
){

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true){
        editViewModel.appEvent.collect{ appEvents ->
            when(appEvents){
                is AppEvents.PopBackStack -> navigateToHome()
                is AppEvents.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = appEvents.message,
                        actionLabel = appEvents.action
                    )
                }
            }
        }
    }

    Scaffold(
        topBar = {
            NewNoteTopBar(navigateToHome = {
                editViewModel.onEvents(EditUiEvents.SaveNote)
            })
        },
        content = { paddingValues ->
            EditContents(
                modifier = Modifier
                    .padding(paddingValues),
                editViewModel = editViewModel
            )
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditContents(
    modifier: Modifier = Modifier,
    editViewModel: EditViewModel
){

    var title by remember {
        mutableStateOf("")
    }
    var contents by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = editViewModel.title,
            onValueChange = {
                editViewModel.onEvents(EditUiEvents.OnTitleChange(it))
            },
            placeholder = {
                Text(text = stringResource(id = R.string.title))
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 0.dp),
            singleLine = true
        )
        OutlinedTextField(
            value = editViewModel.content,
            onValueChange = {
                editViewModel.onEvents(EditUiEvents.OnContentChange(it))
            },
            placeholder = {
                Text(text = stringResource(id = R.string.description))
            },
            modifier = modifier.fillMaxSize()
        )
    }
}

@Preview("Edit Screen")
@Preview("EditScreen (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEditScreen() {

    val editViewModel : EditViewModel by viewModel()

    NoteAppTheme {
        EditScreen(navigateToHome = {}, editViewModel)
    }
}

@Preview("Edit Screen contents")
@Preview("EditScreen contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEditScreenContents() {

    val editViewModel : EditViewModel by viewModel()

    NoteAppTheme {
        EditContents(editViewModel = editViewModel)
    }
}
