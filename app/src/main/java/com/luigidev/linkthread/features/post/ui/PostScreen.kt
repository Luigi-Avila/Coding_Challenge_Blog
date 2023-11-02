package com.luigidev.linkthread.features.post.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luigidev.linkthread.core.ErrorScreen
import com.luigidev.linkthread.features.post.domain.states.PostUIState
import com.luigidev.linkthread.features.post.ui.states.PostFillOutScreen
import com.luigidev.linkthread.features.post.ui.states.PostSuccessScreen

@Composable
fun PostScreen(navController: NavHostController) {

    val postViewModel = hiltViewModel<PostViewModel>()

    when (postViewModel.postUIState) {
        is PostUIState.Error -> {
            ErrorScreen()
        }

        PostUIState.FillOut -> {
            PostFillOutScreen(postViewModel = postViewModel, navController)
        }

        PostUIState.Loading -> {
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        PostUIState.Success -> {
            PostSuccessScreen(navController, postViewModel)
        }
    }

}