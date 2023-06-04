package com.joel.noteapp.core.design.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.joel.noteapp.R
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme
import com.joel.noteapp.core.utils.Actions
import com.joel.noteapp.navigation.DrawerNavOption
import com.joel.noteapp.navigation.NavRoutes
import com.joel.noteapp.screens.favourite.FAVOURITE_ROUTE
import com.joel.noteapp.screens.home.HOME_SCREEN
import com.joel.noteapp.screens.settings.SETTINGS_ROUTE
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavDrawer(
    currentRoute: String,
    navigateToHome: (Actions) -> Unit,
    navigateToFavourites: () -> Unit,
    navigateToSettings: () -> Unit,
    navigateToTags: () -> Unit,
    closeDrawer: () -> Unit,
    modifier: Modifier = Modifier,
){

    ModalDrawerSheet(modifier) {
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.home)) },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_home_24), contentDescription = stringResource(id = R.string.home_info_description)) },
            selected = currentRoute == HOME_SCREEN,
            onClick = { navigateToHome; closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.favourites)) },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_favorite_24), contentDescription = stringResource(id = R.string.favourites_info_description)) },
            selected = currentRoute == FAVOURITE_ROUTE,
            onClick = { navigateToFavourites(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.tag)) },
            icon = { Icon(painter = painterResource(id = R.drawable.tag_icon), contentDescription = stringResource(id = R.string.tag_info_description)) },
            selected = currentRoute == "",
            onClick = { navigateToTags() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding).size(25.dp)

        )
        NavigationDrawerItem(
            label = { Text(stringResource(id = R.string.settings)) },
            icon = { Icon(painter = painterResource(id = R.drawable.baseline_settings_24), contentDescription = stringResource(id = R.string.settings_info_description)) },
            selected = currentRoute == SETTINGS_ROUTE,
            onClick = { navigateToSettings(); closeDrawer() },
            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
        )
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppNavDrawer() {
    NoteAppTheme() {
        AppNavDrawer(
            currentRoute = HOME_SCREEN,
            navigateToHome = {},
            navigateToSettings = {},
            closeDrawer = { },
            navigateToFavourites = {},
            navigateToTags = {}
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    content: @Composable () -> Unit
){


    Surface {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                AppDrawerContent(
                    drawerState = drawerState,
                    menuItems = DrawerParams.drawerButtons,
                    defaultPick = DrawerNavOption.HomeScreen
                ) { onUserPickedOption ->
                    when (onUserPickedOption) {
                        DrawerNavOption.HomeScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        DrawerNavOption.FavouriteScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        DrawerNavOption.TagScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                        DrawerNavOption.SettingsScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }
                    }
                }
            }
        ) {
            content()
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T : Enum<T>> AppDrawerContent(
    drawerState: DrawerState,
    menuItems: List<AppDrawerItemInfo<T>>,
    defaultPick: T,
    onClick: (T) -> Unit
) {
    var currentPick by remember { mutableStateOf(defaultPick) }
    val coroutineScope = rememberCoroutineScope()

    ModalDrawerSheet {
        Surface(color = MaterialTheme.colorScheme.background) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(menuItems) { item ->
                        AppDrawerItem(item = item) { navOption ->

                            if (currentPick == navOption) {
                                coroutineScope.launch {
                                    drawerState.close()
                                }
                                return@AppDrawerItem
                            }

                            currentPick = navOption
                            coroutineScope.launch {
                                drawerState.close()
                            }
                            onClick(navOption)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> AppDrawerItem(item: AppDrawerItemInfo<T>, onClick: (options: T) -> Unit) =
    Surface(
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier
            .width(200.dp)
            .padding(top = 24.dp, start = 4.dp),
        onClick = { onClick(item.drawerOption) },
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),

        ) {
            Icon(
                painter = painterResource(id = item.drawableId),
                contentDescription = stringResource(id = item.descriptionId),
                modifier = Modifier
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = item.title),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center,
            )
        }
    }


class MainStateProvider : PreviewParameterProvider<AppDrawerItemInfo<DrawerNavOption>> {
    override val values = sequence {
        DrawerParams.drawerButtons.forEach { element ->
            yield(element)
        }
    }
}

@Preview
@Composable
fun AppDrawerItemPreview(@PreviewParameter(MainStateProvider::class) state: AppDrawerItemInfo<DrawerNavOption>) {
    NoteAppTheme {
        AppDrawerItem(item = state, onClick = {})
    }
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            DrawerNavOption.HomeScreen,
            R.string.home,
            R.drawable.baseline_home_24,
            R.string.home_info_description
        ),
        AppDrawerItemInfo(
            DrawerNavOption.FavouriteScreen,
            R.string.favourites,
            R.drawable.baseline_favorite_24,
            R.string.favourites_info_description
        ),
        AppDrawerItemInfo(
            DrawerNavOption.TagScreen,
            R.string.tag,
            R.drawable.tag_icon,
            R.string.tag_info_description
        ),
        AppDrawerItemInfo(
            DrawerNavOption.SettingsScreen,
            R.string.settings,
            R.drawable.baseline_settings_24,
            R.string.settings_info_description
        )

    )
}

data class AppDrawerItemInfo<T>(
    val drawerOption: T,
    @StringRes val title: Int,
    @DrawableRes val drawableId: Int,
    @StringRes val descriptionId: Int
)

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview("Drawer contents")
//@Preview("Drawer contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
//@Composable
//fun PreviewAppDrawer() {
//    val navController = rememberNavController()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    NoteAppTheme {
//        AppDrawer(content = {}, navController = navController, drawerState = drawerState)
//    }
//}