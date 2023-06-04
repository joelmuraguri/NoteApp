package com.joel.noteapp.screens.editnotes

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joel.noteapp.core.design.composables.EditScreenAppBar
import com.joel.noteapp.core.design.composables.NewNoteTopBar
import com.joel.noteapp.core.design.composables.NoteDescriptionField
import com.joel.noteapp.core.design.composables.TitleField
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.data.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    viewModel: EditViewModel,
    navigateToHomeScreen : (Actions) -> Unit,
    note : Note?,
    context: Context,
    onPopBackStack : () -> Unit
){

    val title : String = viewModel.title
    val contents : String = viewModel.contents

    BackHandler {
        navigateToHomeScreen(Actions.NO_ACTION)
    }

    Scaffold(
        topBar = {
            EditScreenAppBar(
                note = note,
                navigateToHomeScreen = { actions ->
                    if (actions == Actions.NO_ACTION){
                        navigateToHomeScreen(actions)
                    } else{
                        if (viewModel.validateFields()){
                            navigateToHomeScreen(actions)
                        } else{
                            displayToast(context)
                        }
                    }
                },
                onPopBackStack = onPopBackStack
            )
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TitleField(
                value = title,
                onNewValue = {
                    viewModel.updateTitle(title)
                })
            NoteDescriptionField(
                value = contents,
                onNewValue = {
                    viewModel.updateContents(contents)
                })

        }
    }
}

fun displayToast(context: Context) {
    Toast.makeText(
        context,
        "Fields Empty.",
        Toast.LENGTH_SHORT
    ).show()
}

@Preview("Edit Screen contents")
@Preview("EditScreen contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEditScreen() {

    NoteAppTheme {
//        EditScreen(){
//
//        }
    }
}