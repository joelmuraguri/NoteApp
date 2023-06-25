package com.joel.noteapp.core.design.composables

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.joel.noteapp.R
import com.joel.noteapp.core.design.ui.theme.NoteAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    navigateToSearch: () -> Unit,
){
    TopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.home
                )
            )
                },
        actions = {
            GridViewIcon()
            SearchIcon(navigateToSearch)
        }
    )
    // TODO ;should have navigation icon, search and should be large-top-appbar with image
}



@Composable
fun SearchTopBar(){
    //TODO , should have arrow-back, filter icon, search-field with icon,

}


@Preview("New NoteTop Bar")
@Preview("New NoteTop Bar(dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewNewTopBar() {
    NoteAppTheme {

    }
}

@Preview("ExistingTopBar contents")
@Preview("ExistingTopBar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewExistingTopBar() {
    NoteAppTheme {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("HomeTopBar contents")
@Preview("HomeTopBar contents (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewHomeTopBar() {
    NoteAppTheme {
        HomeTopBar(
            navigateToSearch = {},
        )
    }
}
