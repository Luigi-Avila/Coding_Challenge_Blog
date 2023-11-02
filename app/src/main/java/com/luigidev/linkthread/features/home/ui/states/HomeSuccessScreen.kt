package com.luigidev.linkthread.features.home.ui.states

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.DriveFileRenameOutline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.luigidev.linkthread.R
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.home.ui.HomeViewModel
import com.luigidev.linkthread.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeSuccessScreen(homeViewModel: HomeViewModel, navController: NavHostController) {
    val listState = rememberLazyListState()
    val expandedFab by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0
        }
    }
    val scrollBehavior = TopAppBarDefaults
        .exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val posts by homeViewModel.posts.collectAsState()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Posts", style = MaterialTheme.typography.headlineLarge) },
                scrollBehavior = scrollBehavior,
            )
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Add post") },
                expanded = expandedFab,
                icon = { Icon(imageVector = Icons.Filled.Add, contentDescription = "Add post") },
                onClick = { navController.navigate(Routes.PostScreen.route) }
            )
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)) {
            if (posts.isEmpty()) {
                IsEmpty()
            } else {
                MySearchBar(homeViewModel)
                PostsList(listState, posts)
            }

        }
    }


}

@Composable
fun IsEmpty() {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.empty)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    Box(contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            LottieAnimation(composition = composition, progress = { progress })
        }
    }
}

@Composable
fun MySearchBar(homeViewModel: HomeViewModel) {
    val searchText by homeViewModel.searchText.collectAsState()
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.regularPadding)),
        value = searchText,
        label = { Text(text = "Search...") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search Icon"
            )
        },
        onValueChange = { homeViewModel.onChangeSearchText(it) })

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostsList(listState: LazyListState, posts: List<Post>) {
    LazyColumn(state = listState) {
        items(posts) { post ->
            PostItem(post)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PostItem(post: Post) {

    var short: String by remember {
        mutableStateOf(post.content.take(70))
    }

    ListItem(
        headlineContent = {
            Column {
                Text(text = post.title)
                Text(
                    text = if (short.length == 70) "$short..." else short,
                    modifier = Modifier.clickable {
                        short = if (short.length > 70) {
                            short.take(70)
                        } else {
                            post.content
                        }
                    }
                )
            }
        },
        leadingContent = {
            Icon(
                imageVector = Icons.Outlined.DriveFileRenameOutline,
                contentDescription = "Blog icon"
            )
        },
        supportingContent = {
            Text(text = post.dateTime)
        },
        trailingContent = {
            Text(text = post.author)
        }
    )
}
