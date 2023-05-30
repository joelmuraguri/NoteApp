package com.example.design.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleField(
    value : String,
    onNewValue : (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder : String
){

    OutlinedTextField(
        singleLine = true,
        shape = RoundedCornerShape(15.dp),
        value = value,
        onValueChange = {
            onNewValue(it)
        },
    )

}