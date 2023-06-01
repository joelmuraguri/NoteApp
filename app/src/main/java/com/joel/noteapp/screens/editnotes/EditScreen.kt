package com.joel.noteapp.screens.editnotes

import android.content.res.Configuration
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
import com.joel.noteapp.core.design.composables.NewNoteTopBar
import com.joel.noteapp.core.design.composables.NoteDescriptionField
import com.joel.noteapp.core.design.composables.TitleField
import com.joel.noteapp.core.ui.theme.NoteAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(
    onPopBackStack : () -> Unit
){

    Scaffold(
        topBar = {
            NewNoteTopBar(onPopBackStack)
        }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TitleField(value = "", onNewValue = {})
            NoteDescriptionField(value = "", onNewValue = {})

        }
    }

}

@Preview("Edit Screen contents")
@Preview("EditScreen contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewEditScreen() {
    NoteAppTheme {
        EditScreen(onPopBackStack = {})
    }
}