package com.example.design.composables

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.example.design.icons.NAIcons


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTopBar(
    onPopBackStack : () -> Unit
){

    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = NAIcons.arrowBack, contentDescription = "")
            }
        }
    )

}