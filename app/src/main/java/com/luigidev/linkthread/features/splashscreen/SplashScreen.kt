package com.luigidev.linkthread.features.splashscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.luigidev.linkthread.R
import com.luigidev.linkthread.navigation.Routes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    LaunchedEffect(true) {
        delay(2_000)
        navController.popBackStack()
        navController.navigate(Routes.HomeScreen.route)
    }
    Splash()

}

@Composable
fun Splash() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.blog)
    )
    val progress by animateLottieCompositionAsState(composition = composition)

    Box(
        Modifier.then(
            if (isSystemInDarkTheme()) {
                Modifier.background(Color.Black)
            } else {
                Modifier.background(Color.Gray)
            }
        ),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(composition = composition, progress = { progress })
    }

}
