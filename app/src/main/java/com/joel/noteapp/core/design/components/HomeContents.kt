package com.joel.noteapp.core.design.components

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.data.models.Note
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.foundation.lazy.items
import com.joel.noteapp.core.utils.RequestState


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeContents(
    allNotes : RequestState<List<Note>>,
    navigateToEditScreen: (taskId: Int) -> Unit,
    onSwipeToDelete: (Actions, Note) -> Unit,
    modifier: Modifier = Modifier
){

    if (allNotes is RequestState.Success){
        HandleListContent(
            notes = allNotes.data,
            navigateToEditScreen = navigateToEditScreen,
            onSwipeToDelete = onSwipeToDelete
        )
    }

}

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalAnimationApi
@Composable
fun HandleListContent(
    notes: List<Note>,
    navigateToEditScreen: (taskId: Int) -> Unit,
    onSwipeToDelete: (Actions, Note) -> Unit,
) {
    if (notes.isEmpty()) {
        EmptyContent()
    } else {
        DisplayNotes(
            notes = notes,
            navigateToEditScreen = navigateToEditScreen,
            onSwipeToDelete = onSwipeToDelete
        )
    }
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
                text = note.content,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(12.dp)
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
            text = stringResource(id = R.string.no_notes_found),
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun HandleListContent(
    tasks: List<Note>,
    onSwipeToDelete: (Actions, Note) -> Unit,
    navigateToEditScreen: (taskId: Int) -> Unit
) {
    if (tasks.isEmpty()) {
        EmptyContent()
    } else {
        DisplayNotes(
            notes = tasks,
            onSwipeToDelete = onSwipeToDelete,
            navigateToEditScreen = navigateToEditScreen
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun DisplayNotes(
    notes: List<Note>,
    onSwipeToDelete: (Actions, Note) -> Unit,
    navigateToEditScreen: (taskId: Int) -> Unit
) {
    LazyColumn {
        items(
            items = notes,
            key = { note ->
                note.id
            }
        ) { note ->
            val dismissState = rememberDismissState()
            val dismissDirection = dismissState.dismissDirection
            val isDismissed = dismissState.isDismissed(DismissDirection.EndToStart)
            if (isDismissed && dismissDirection == DismissDirection.EndToStart) {
                val scope = rememberCoroutineScope()
                SideEffect {
                    scope.launch {
                        delay(300)
                        onSwipeToDelete(Actions.DELETE, note)
                    }
                }
            }

            val degrees by animateFloatAsState(
                if (dismissState.targetValue == DismissValue.Default)
                    0f
                else
                    -45f
            )

            var itemAppeared by remember { mutableStateOf(false) }
            LaunchedEffect(key1 = true){
                itemAppeared = true
            }

            AnimatedVisibility(
                visible = itemAppeared && !isDismissed,
                enter = expandVertically(
                    animationSpec = tween(
                        durationMillis = 300
                    )
                ),
                exit = shrinkVertically(
                    animationSpec = tween(
                        durationMillis = 300
                    )
                )
            ) {
                SwipeToDismiss(
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    dismissThresholds = { FractionalThreshold(fraction = 0.2f) },
                    background = { RedBackground(degrees = degrees) },
                    dismissContent = {
                        NoteItem(
                            navigateToEditScreen = navigateToEditScreen,
                            note = note
                        )
                    }
                )
            }
        }
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