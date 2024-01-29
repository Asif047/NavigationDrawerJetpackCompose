package com.example.navigationdrawer

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer

import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationdrawer.appdrawer.AppDrawerContent
import com.example.navigationdrawer.appdrawer.AppDrawerItemInfo
import com.example.navigationdrawer.ui.theme.NavigationDrawerTheme

@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),

) {
    NavigationDrawerTheme {
        Surface {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    AppDrawerContent(
                        drawerState = drawerState,
                        menuItems = DrawerParams.drawerButtons,
                        defaultPick = MainNavOption.HomeScreen
                    ) { onUserPickedOption ->
                        when (onUserPickedOption) {
                            MainNavOption.HomeScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.SettingsScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.AboutScreen -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                        }
                    }
                }
            ) {

                NavHost(
                    navController,
                    startDestination =  NavRoutes.MainRoute.name
                ) {

                    mainGraph(drawerState)
                }
            }
        }
    }
}

enum class NavRoutes {
    IntroRoute,
    MainRoute,
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.HomeScreen,
            R.string.drawer_home,
            R.drawable.ic_home,
            R.string.drawer_home_description
        ),
        AppDrawerItemInfo(
            MainNavOption.SettingsScreen,
            R.string.drawer_settings,
            R.drawable.ic_settings,
            R.string.drawer_settings_description
        ),
        AppDrawerItemInfo(
            MainNavOption.AboutScreen,
            R.string.drawer_about,
            R.drawable.ic_info,
            R.string.drawer_info_description
        )
    )
}

@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}