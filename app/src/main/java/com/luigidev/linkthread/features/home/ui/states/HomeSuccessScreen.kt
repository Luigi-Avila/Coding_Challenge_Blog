package com.luigidev.linkthread.features.home.ui.states

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.luigidev.linkthread.features.home.ui.HomeViewModel

@Composable
fun HomeSuccessScreen(homeViewModel: HomeViewModel) {
    val listState = rememberLazyListState()
    val fabExpanded by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0
        }
    }

    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add choir") },
                expanded = fabExpanded,
                icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add post") },
                onClick = { /*TODO*/ }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        PostsList(Modifier.padding(it), homeViewModel)
    }


}

@Composable
fun PostsList(modifier: Modifier, homeViewModel: HomeViewModel) {
    val posts by homeViewModel.posts.collectAsState()
    val searchText by homeViewModel.searchText.collectAsState()
    LazyColumn(modifier = modifier) {
        item {
            TextField(
                value = searchText,
                onValueChange = { homeViewModel.onChangeSearchText(it) })
        }
        items(posts) { post ->
            Text(text = post.title)
        }
    }
}