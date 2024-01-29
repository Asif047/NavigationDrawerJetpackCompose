package com.example.navigationdrawer.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.navigationdrawer.R
import com.example.navigationdrawer.appbar.AppBar

@Composable
fun HomeScreen(drawerState: DrawerState) {
    Scaffold(

        topBar = {
            AppBar(drawerState = drawerState, title = R.string.drawer_home)
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it).background(Color.Blue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Home")
        }
    }
}