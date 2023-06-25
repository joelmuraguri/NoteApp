package com.joel.noteapp.core.design.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.joel.noteapp.R


@Composable
fun AddFAB(onAdd : () -> Unit){
    // TODO ; add/note icon or with text
    FloatingActionButton(onClick = { onAdd() }) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.add_info_description))
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
