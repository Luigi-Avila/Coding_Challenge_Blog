package com.luigidev.linkthread.navigation

sealed class Routes(val route: String) {
    object SplashScreen : Routes("SplashScreen")
    object HomeScreen : Routes("HomeScreen")
    object PostScreen : Routes("PostScreen")
}
