package dev.android.superest_compose.presentation.navigaton

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import dev.android.superest_compose.presentation.SplashScreen
import dev.android.superest_compose.presentation.Welcome

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Splashscreen.route) {

        // First route : Home
        composable(Screen.Splashscreen.route) {

            // Lay down the Home Composable
            // and pass the navController
            SplashScreen(navController = navController)
        }

        // Another Route : Profile
        composable(Screen.Welcome.route) {
            // Profile Screen
            Welcome(navController = navController)
        }

        // Settings Route, Notice the "/{id}" in last,
        // its the argument passed down from homeScreen
     /*   composable(Screen.LoginScreen.route){
            // Pass the extracted Counter
            LoginScreen(navController = navController)
        }  */
    }
}