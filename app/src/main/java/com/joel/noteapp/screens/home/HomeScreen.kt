package com.joel.noteapp.screens.home

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.noteapp.core.design.composables.AddFAB
import com.joel.noteapp.core.design.composables.HomeTopBar
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.data.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAdd : () -> Unit,
    navigateToSearch : () -> Unit,
    homeViewModel: HomeViewModel
){


    Scaffold(
        topBar = {
            HomeTopBar(navigateToSearch = navigateToSearch)
        },
        floatingActionButton = {
            AddFAB( onAdd = onAdd)
        },
        content = { paddingValues ->
            HomeContents(
                homeViewModel = homeViewModel,
                modifier = Modifier
                    .padding(paddingValues)
            )
        },
    )
}

@Composable
fun HomeContents(
    homeViewModel: HomeViewModel,
    modifier: Modifier = Modifier
){

    val notes = homeViewModel.notes.collectAsState(initial = emptyList())

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        items(notes.value){ note ->
            NoteItem(note = note)

        }
    }
}


@Composable
fun NoteItem(
    note: Note
){

    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
//            .height(200.dp)
//            .width(200.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                text = note.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = note.content,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview("Note Item")
@Preview("Note Item (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNoteItem() {

    val note = Note(
        title = "Kotlin",
        content = "Ktor Backend Development, develop a chat app using web sockets."
    )

    NoteAppTheme {
        NoteItem(note = note)
    }
}