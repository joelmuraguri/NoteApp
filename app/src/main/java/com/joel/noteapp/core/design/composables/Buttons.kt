package com.joel.noteapp.core.design.composables

import android.util.Log
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joel.noteapp.R
import com.joel.noteapp.core.design.NAIcons
import com.joel.noteapp.core.utils.Actions
import kotlinx.coroutines.launch


@Composable
fun AddFAB(
    onFabClicked: (taskId: Int) -> Unit
){
    // TODO ; add/note icon or with text
    FloatingActionButton(onClick = { onFabClicked(-1) }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.add_info_description))
    }
}

@Composable
fun EditFAB(){
    // TODO ; edit icon with text
}

@Composable
fun ArrowBackNav(
    navigateToHomeScreen : (Actions) -> Unit
){
    IconButton(onClick = { navigateToHomeScreen }) {
        Icon(
            imageVector = NAIcons.arrowBack,
            contentDescription = stringResource(id = R.string.arrowBack_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
@Composable
fun DrawerMenuButton(
    openDrawer : () -> Unit
){
    IconButton(onClick = { openDrawer }) {
        Icon(
            Icons.Rounded.Menu,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = stringResource(id = R.string.menu_info_description)
        )
    }
}

@Composable
fun SaveButton(
    navigateToHomeScreen : (Actions) -> Unit,
    onPopBackStack : () -> Unit
){
    IconButton(onClick = { navigateToHomeScreen }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_check_24),
            contentDescription = stringResource(id = R.string.save_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun TagButton(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.tag_icon),
            contentDescription = stringResource(id = R.string.tag_info_description),
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier
                .size(25.dp)
        )
    }
}

@Composable
fun PickColorIcon(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_color_lens_24),
            contentDescription = stringResource(id = R.string.pick_color_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
@Composable

fun HorizontalMoreVert(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_more_horiz_24),
            contentDescription = stringResource(id = R.string.horizontal_more_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerIcon(drawerState: DrawerState) {
    Log.d("ICON", "menu icon")
    val coroutineScope = rememberCoroutineScope()
    IconButton(onClick = {
        coroutineScope.launch {
            drawerState.open()
        }
    }) {
        Icon(
            Icons.Rounded.Menu,
            tint = MaterialTheme.colorScheme.onBackground,
            contentDescription = stringResource(id = R.string.menu_info_description)
        )
    }
}


@Composable
fun GridViewIcon(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_grid_view_24),
            contentDescription = stringResource(id = R.string.grid_view_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
fun SearchIcon(
    navigateToSearch: () -> Unit
){
    IconButton(onClick = { navigateToSearch() }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.settings_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
