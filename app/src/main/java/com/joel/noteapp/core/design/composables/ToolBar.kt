package com.joel.noteapp.core.design.composables

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.data.models.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navigateToSearch: () -> Unit,
    openDrawer : () -> Unit,
){
    TopAppBar(
        navigationIcon = {
            DrawerMenuButton(openDrawer)
        },
        title = {},
        actions = {
            GridViewIcon()
            SearchIcon(navigateToSearch)
        }
    )
    // TODO ;should have navigation icon, search and should be largetopappbar with image

}

@Composable
fun EditScreenAppBar(
    note: Note?,
    navigateToHomeScreen: (Actions) -> Unit,
    onPopBackStack : () -> Unit
) {
    if (note == null) {
        NewNoteTopBar(navigateToHomeScreen = navigateToHomeScreen, onPopBackStack = onPopBackStack)
    } else {
        ExistingNoteTopBar(
            navigateToHomeScreen = navigateToHomeScreen
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteTopBar(
    navigateToHomeScreen : (Actions) -> Unit,
    onPopBackStack : () -> Unit

){
    //TODO ; should have save/arrow-back, color picker, tag, horizontal more vert{ bottom sheet for reminder, move to trash, add to favourites}

    TopAppBar(
        navigationIcon = {
            SaveButton( navigateToHomeScreen, onPopBackStack )
        },
        title = {},
        actions = {
            PickColorIcon()
            TagButton()
            HorizontalMoreVert()
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingNoteTopBar(navigateToHomeScreen : (Actions) -> Unit){
    //TODO ; should have arrow-back, color picker, tag, horizontal more vert{ bottom sheet for reminder, move to trash, add to favourites}
    TopAppBar(
        navigationIcon = {
            ArrowBackNav(navigateToHomeScreen)
        },
        title = {},
        actions = {
            PickColorIcon()
            TagButton()
            HorizontalMoreVert()
        }
    )
}

@Composable
fun SearchTopBar(){
    //TODO , should have arrow-back, filter icon, searchfield with icon,

}


@Preview("New NoteTop Bar")
@Preview("New NoteTop Bar(dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNewTopBar() {
    NoteAppTheme {
        NewNoteTopBar(
            onPopBackStack = {},
            navigateToHomeScreen = {}
        )
    }
}

@Preview("ExistingTopBar contents")
@Preview("ExistingTopBar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewExistingTopBar() {
    NoteAppTheme {
        ExistingNoteTopBar(){

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("HomeTopBar contents")
@Preview("HomeTopBar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeTopBar() {
    NoteAppTheme {
        HomeTopBar(
            navigateToSearch = {},
            openDrawer = {}
        )
    }
}
