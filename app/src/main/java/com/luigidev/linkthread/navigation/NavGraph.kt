package com.luigidev.linkthread.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luigidev.linkthread.features.home.ui.HomeScreen
import com.luigidev.linkthread.features.home.ui.HomeViewModel
import com.luigidev.linkthread.features.post.ui.PostScreen
import com.luigidev.linkthread.features.post.ui.PostViewModel

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    homeViewModel: HomeViewModel,
    postViewModel: PostViewModel
) {
    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {
        composable(Routes.SplashScreen.route) { Text(text = "Splash Screen") }
        composable(Routes.HomeScreen.route) { HomeScreen(homeViewModel) }
        composable(Routes.PostScreen.route) { PostScreen(postViewModel) }
    }
}