package com.joel.noteapp.core.design.composables

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    drawerState: DrawerState? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    navigateToSearch: () -> Unit
){
    TopAppBar(
        navigationIcon = {
            if (drawerState != null && navigationIcon == null){
                DrawerIcon(drawerState = drawerState)
            } else {
                navigationIcon?.invoke()
            }
        },
        title = {},
        actions = {
            GridViewIcon()
            SearchIcon(navigateToSearch)
        }
    )
    // TODO ;should have navigation icon, search and should be largetopappbar with image

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewNoteTopBar(
    onPopBackStack : () -> Unit
){
    //TODO ; should have save/arrow-back, color picker, tag, horizontal more vert{ bottom sheet for reminder, move to trash, add to favourites}

    TopAppBar(
        navigationIcon = {
            SaveButton( onPopBackStack)
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
fun ExistingNoteTopBar(){
    //TODO ; should have arrow-back, color picker, tag, horizontal more vert{ bottom sheet for reminder, move to trash, add to favourites}
}

@Composable
fun SearchTopBar(){
    //TODO , should have arrow-back, filter icon, searchfield with icon,

}
