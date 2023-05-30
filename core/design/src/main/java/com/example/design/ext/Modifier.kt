package com.example.design.ext

import androidx.compose.foundation.layout.height
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.descriptionFieldHeight() : Modifier{
    return this.height(150.dp)
}