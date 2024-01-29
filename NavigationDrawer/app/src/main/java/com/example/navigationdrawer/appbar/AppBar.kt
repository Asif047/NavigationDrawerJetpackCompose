package com.example.navigationdrawer.appbar

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.navigationdrawer.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    drawerState: DrawerState? = null,
    navigationIcon: (@Composable () -> Unit)? = null,
    @StringRes title: Int? = null,
    appBarActions: List<AppBarAction>? = null
) {
    val coroutineScope = rememberCoroutineScope()

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(Color.Magenta),
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxWidth(),
        title = {
            title?.let {


                    Text(
                        text = "Hello",
                        style = MaterialTheme.typography.titleMedium
                    )



            }
        },
        actions = {
            appBarActions?.let {
                for (appBarAction in it) {
                    AppBarAction(appBarAction)
                }
            }
        },
        navigationIcon = {
            if (drawerState != null && navigationIcon == null){
                DrawerIcon(drawerState = drawerState)
            } else {
                navigationIcon?.invoke()
            }
        },
    )
}

@Composable
private fun DrawerIcon(drawerState: DrawerState) {
    val coroutineScope = rememberCoroutineScope()
    IconButton(onClick = {
        coroutineScope.launch {
            drawerState.open()
        }
    }) {



            Icon(
                Icons.Rounded.Menu,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = ""
            )




    }
}

@Composable
fun AppBarAction(appBarAction: AppBarAction) {
    IconButton(onClick = appBarAction.onClick) {
        Row(
            modifier = Modifier
                .background(Color.Yellow)
                .fillMaxWidth()
        ) {

            Icon(
                painter = painterResource(id = appBarAction.icon),
                modifier = Modifier.size(24.dp),
                tint = Color.Magenta,
                contentDescription = stringResource(id = appBarAction.description)
            )

        }

    }
}