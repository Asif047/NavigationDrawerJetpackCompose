package com.example.navigationdrawer

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.navigationdrawer.screens.AboutScreen
import com.example.navigationdrawer.screens.HomeScreen
import com.example.navigationdrawer.screens.SettingsScreen

fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.HomeScreen.name){
            HomeScreen(drawerState)
        }
        composable(MainNavOption.SettingsScreen.name){
            SettingsScreen(drawerState)
        }
        composable(MainNavOption.AboutScreen.name){
            AboutScreen(drawerState)
        }
    }
}

enum class MainNavOption {
    HomeScreen,
    AboutScreen,
    SettingsScreen,
}
