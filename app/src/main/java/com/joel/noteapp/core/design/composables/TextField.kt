package com.joel.noteapp.core.design.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joel.noteapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleField(
    title : String,
    onTitleValue : (String) -> Unit
){
    //TODO ; should have placeholder text, sing-line
    OutlinedTextField(
        value = title,
        onValueChange = {onTitleValue(it)},
        singleLine = true,
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .border(BorderStroke(0.dp, color = MaterialTheme.colorScheme.onPrimary)),
        placeholder = {
            Text(
                text = stringResource(id = R.string.title),
                color = Color.LightGray,
                fontSize = 24.sp
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteContentsField(
    contents : String,
    onContentsValue : (String) -> Unit
){
    //TODO ; should have placeholder text, fills remaining height,vertical scroll will be handy
    OutlinedTextField(
        value = contents,
        onValueChange = {onContentsValue(it)},
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
            .border(BorderStroke(0.dp, color = MaterialTheme.colorScheme.onPrimary)),
        placeholder = {
            Text(
                text = stringResource(id = R.string.description),
                color = Color.LightGray,
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.onPrimary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}