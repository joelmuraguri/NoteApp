package com.joel.noteapp.core.design.components

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.joel.noteapp.R
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.screens.favourite.FAVOURITE_ROUTE
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.settings.SETTINGS_ROUTE

@Composable
fun AppNavRail(
    currentRoute : String,
    navigateToHome : () -> Unit,
    navigateToFavorites : () -> Unit,
    navigateToTags : () -> Unit,
    navigateToSettings : () -> Unit
){

    NavigationRail {
        NavigationRailItem(
            selected = currentRoute == HOME_SCREEN,
            onClick = { navigateToHome() },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = stringResource(id = R.string.home_info_description)) },
            label = { Text(stringResource(R.string.home)) },
            alwaysShowLabel = false
        )
        NavigationRailItem(
            selected = currentRoute == FAVOURITE_ROUTE,
            onClick = { navigateToFavorites() },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = stringResource(id = R.string.favourites_info_description)) },
            label = { Text(stringResource(R.string.favourites)) },
            alwaysShowLabel = false
        )
        NavigationRailItem(
            selected = currentRoute == "",
            onClick = { navigateToTags() },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_tag_24), contentDescription = stringResource(id = R.string.tag_info_description)) },
            label = { Text(stringResource(R.string.tag)) },
            alwaysShowLabel = false
        )
        NavigationRailItem(
            selected = currentRoute == SETTINGS_ROUTE,
            onClick = { navigateToSettings() },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = stringResource(id = R.string.settings_info_description)) },
            label = { Text(stringResource(R.string.settings)) },
            alwaysShowLabel = false
        )
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavRail() {
    NoteAppTheme {
        AppNavRail(
            currentRoute = HOME_SCREEN,
            navigateToHome = {},
            navigateToFavorites = {},
            navigateToTags = {},
            navigateToSettings = {}
        )
    }
}