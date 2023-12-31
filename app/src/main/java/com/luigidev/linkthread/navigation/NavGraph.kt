package com.luigidev.linkthread.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luigidev.linkthread.features.home.ui.HomeScreen
import com.luigidev.linkthread.features.post.ui.PostScreen
import com.luigidev.linkthread.features.splashscreen.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) { SplashScreen(navController) }
        composable(Routes.HomeScreen.route) { HomeScreen(navController) }
        composable(Routes.PostScreen.route) { PostScreen(navController) }
    }
}