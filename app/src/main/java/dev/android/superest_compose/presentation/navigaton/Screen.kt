package dev.android.superest_compose.presentation.navigaton

import dev.android.superest_compose.R
import dev.android.superest_compose.presentation.NavigationItem

sealed class Screen(val route: String) {

    object Splashscreen: Screen("splashscreen")

    object Welcome: Screen("welcome")

    object  LoginScreen: Screen("LoginScreen")
    object Shop : Screen("shop")
    object Explore : Screen("explore")
    object Cart : Screen("cart")
    object Favourite : Screen("favorite")
}
