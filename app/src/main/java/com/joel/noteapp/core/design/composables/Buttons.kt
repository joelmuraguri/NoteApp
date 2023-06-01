package com.joel.noteapp.core.design.composables

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.joel.noteapp.R
import com.joel.noteapp.core.design.Icon.ImageVectorIcon
import com.joel.noteapp.core.design.NAIcons
import kotlinx.coroutines.launch


@Composable
fun AddFAB(){
    // TODO ; add/note icon or with text
}

@Composable
fun EditFAB(){
    // TODO ; edit icon with text
}

@Composable
fun ArrowBackNav(){
    // TODO ; arrow-back icon
}

@Composable
fun SaveButton(){
    // TODO ; tick icon
}

@Composable
fun TagButton(){
    //TODO ; should have tag icon
}

@Composable
fun HorizontalMoreVert(){
    //TODO ; should have HorizontalMoreVert icon
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
fun SearchIcon(){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.settings_info_description),
            tint = MaterialTheme.colorScheme.onBackground
        )
    }
}
