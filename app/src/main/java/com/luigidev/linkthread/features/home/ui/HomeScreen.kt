package com.luigidev.linkthread.features.home.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.luigidev.linkthread.features.home.domain.states.HomeUIState

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    val posts by homeViewModel.posts.collectAsState()
    val searchText by homeViewModel.searchText.collectAsState()

    when(homeViewModel.homeUIState){
        is HomeUIState.Error -> { Text(text = "Error")}
        HomeUIState.Loading -> { Text(text = "Loading")}
        HomeUIState.Success -> {
            LazyColumn{
                item { Text(text = "Success") }
                item { TextField(value = searchText, onValueChange ={ homeViewModel.onChangeSearchText(it) } ) }
                items(posts) { post ->
                    Text(text = post.title)
                }
            }
        }
    }

}

