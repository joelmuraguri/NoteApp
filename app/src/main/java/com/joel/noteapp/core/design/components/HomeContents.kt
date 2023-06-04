package com.joel.noteapp.core.design.components

import android.content.res.Configuration
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.noteapp.R
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.data.models.Note

@Composable
fun HomeContents(){

}

@ExperimentalAnimationApi
@Composable
fun HandleListContent(
    notes: List<Note>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (notes.isEmpty()) {
        EmptyContent()
    } else {
        DisplayTasks(
            notes = notes,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun DisplayTasks(
    notes: List<Note>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
//    LazyColumn {
//       item(notes){
//           NoteItem(navigateToEditScreen = navigateToTaskScreen, note = notes)
//       }
//    }
}

@Composable
fun NoteItem(
    navigateToEditScreen: (taskId: Int) -> Unit,
    note: Note
){

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .clickable { navigateToEditScreen(note.id) }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = note.title,
                fontSize = 23.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(12.dp)
            )
            Text(
                text = note.title,
                fontWeight = FontWeight.Light
            )
        }
    }
}

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(120.dp),
            painter = painterResource(id = R.drawable.ic_sad_face),
            contentDescription = stringResource(id = R.string.sad_face_icon),
        )
        Text(
            text = stringResource(id = R.string.no_tasks_found),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

    }
}

@Composable
fun RedBackground(degrees: Float) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
            .padding(horizontal = 24.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(
            modifier = Modifier.rotate(degrees = degrees),
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(id = R.string.delete_icon),
            tint = Color.White
        )
    }
}

@Preview("EmptyContent contents")
@Preview("EmptyContent(dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun EmptyContentPreview(){
    EmptyContent()
}

@Preview("NoteItem contents")
@Preview("NoteItem(dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNoteItem() {
    NoteAppTheme {
        NoteItem(
            navigateToEditScreen = {},
            note = Note(
                id = 0,
                title = "Gaming",
                content = "Finish up Career mode with Brighton Albion #F23"
            ))
    }
}