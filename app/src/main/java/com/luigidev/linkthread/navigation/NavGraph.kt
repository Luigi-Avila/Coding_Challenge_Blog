package com.luigidev.linkthread.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luigidev.linkthread.features.home.ui.HomeScreen
import com.luigidev.linkthread.features.home.ui.HomeViewModel
import com.luigidev.linkthread.features.post.ui.PostScreen
import com.luigidev.linkthread.features.post.ui.PostViewModel
import com.luigidev.linkthread.features.splashscreen.SplashScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    postViewModel: PostViewModel
) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) { SplashScreen(navController) }
        composable(Routes.HomeScreen.route) { HomeScreen(homeViewModel, navController) }
        composable(Routes.PostScreen.route) { PostScreen(postViewModel, navController) }
    }
}