package com.joel.noteapp.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.joel.noteapp.core.design.composables.AddFAB
import com.joel.noteapp.core.design.composables.HomeTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onAdd : () -> Unit,
    navigateToSearch : () -> Unit
){
    Scaffold(
        topBar = {
            HomeTopBar(navigateToSearch = navigateToSearch)
        },
        floatingActionButton = {
            AddFAB( onAdd = onAdd)
        },
        content = { paddingValues ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(paddingValues)
            ) {

            }
        },
    )
}
