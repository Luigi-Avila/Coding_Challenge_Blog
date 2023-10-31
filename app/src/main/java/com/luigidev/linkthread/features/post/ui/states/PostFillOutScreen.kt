package com.luigidev.linkthread.features.post.ui.states

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import com.luigidev.linkthread.features.post.ui.PostViewModel

@Composable
fun PostFillOutScreen(postViewModel: PostViewModel){
    Column {
        TextField(value = postViewModel.title, onValueChange = { postViewModel.onChangeTitle(it) })
        TextField(value = postViewModel.content, onValueChange = { postViewModel.onChangeContent(it) })
        Button(onClick = { postViewModel.sendPost() }) {
            Text(text = "Post")
        }
    }
}