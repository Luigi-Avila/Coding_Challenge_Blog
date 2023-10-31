package com.luigidev.linkthread.features.post.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.luigidev.linkthread.features.post.domain.states.PostUIState
import com.luigidev.linkthread.features.post.ui.states.PostFillOutScreen

@Composable
fun PostScreen(postViewModel: PostViewModel) {

    when(postViewModel.postUIState){
        is PostUIState.Error -> { Text(text = "Error") }
        PostUIState.FillOut -> { PostFillOutScreen(postViewModel = postViewModel) }
        PostUIState.Loading -> { Text(text = "Loading") }
        PostUIState.Success -> { Row {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Go to home")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Upload new")
            }
        } }
    }

}