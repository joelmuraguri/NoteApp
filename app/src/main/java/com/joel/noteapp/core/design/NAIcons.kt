package com.joel.noteapp.core.design

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.joel.noteapp.R

object NAIcons {

    val arrowBack = Icons.Filled.ArrowBack
    val add = Icons.Filled.Add
    val edit = R.drawable.baseline_edit_24
    val reminder = R.drawable.baseline_add_reminder_24
    val moreVert = R.drawable.baseline_more_horiz_24
    val search = Icons.Filled.Search
    val favourites = Icons.Filled.Favorite
    val settings = Icons.Filled.Settings
    val menu = Icons.Filled.Menu
    val trash = Icons.Filled.Delete
    val filter = R.drawable.baseline_filter_alt_24
    val tag = R.drawable.tag_icon
    val home = Icons.Filled.Home


}

sealed class Icon {
    data class ImageVectorIcon(
        val imageVector: ImageVector,
        val description : String,
        val tint : Color
    ) : Icon()
    data class DrawableResourceIcon(@DrawableRes val id: Int) : Icon()
}
