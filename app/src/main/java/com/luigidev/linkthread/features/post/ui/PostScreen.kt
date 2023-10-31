package com.luigidev.linkthread.features.post.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.luigidev.linkthread.features.post.domain.states.PostUIState
import com.luigidev.linkthread.features.post.ui.states.PostFillOutScreen
import com.luigidev.linkthread.navigation.Routes

@Composable
fun PostScreen(postViewModel: PostViewModel, navController: NavHostController) {

    when(postViewModel.postUIState){
        is PostUIState.Error -> { Text(text = "Error") }
        PostUIState.FillOut -> { PostFillOutScreen(postViewModel = postViewModel) }
        PostUIState.Loading -> { Text(text = "Loading") }
        PostUIState.Success -> { Row {
            Button(onClick = { navController.navigate(Routes.HomeScreen.route) }) {
                Text(text = "Go to home")
            }
            Button(onClick = { postViewModel.resetPost() }) {
                Text(text = "Upload new")
            }
        } }
    }

}