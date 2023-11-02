package com.luigidev.linkthread.features.post.ui.states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.luigidev.linkthread.R
import com.luigidev.linkthread.features.post.ui.PostViewModel
import com.luigidev.linkthread.navigation.Routes

@Composable
fun PostSuccessScreen(navController: NavController, postViewModel: PostViewModel) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.success)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(contentAlignment = Alignment.Center) {
        Column(
            Modifier.padding(dimensionResource(id = R.dimen.regularPadding)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(composition = composition, progress = { progress })
            Text(
                text = "Post Saved!",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.displayMedium
            )
            OutlinedButton(onClick = { postViewModel.resetPost() }) {
                Text(text = "Upload new")
            }
            Button(onClick = { navController.navigate(Routes.HomeScreen.route) }) {
                Text(text = "Go to home")
            }
        }
    }
}