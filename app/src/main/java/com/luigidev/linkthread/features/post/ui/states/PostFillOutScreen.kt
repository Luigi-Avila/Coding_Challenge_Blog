package com.luigidev.linkthread.features.post.ui.states

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavController
import com.luigidev.linkthread.R
import com.luigidev.linkthread.core.TextFieldPost
import com.luigidev.linkthread.features.post.ui.PostViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostFillOutScreen(postViewModel: PostViewModel, navigationController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Add Post") },
            actions = {
                IconButton(onClick = { postViewModel.sendPost() }) {
                    Icon(imageVector = Icons.Filled.Save, contentDescription = "Save Post")
                }
            },
            navigationIcon = {
                IconButton(onClick = { postViewModel.goToHome(navigationController) }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Go back")
                }
            }
        )
    }
    ) { paddingValues ->
        Column(
            Modifier.padding(
                top = paddingValues.calculateTopPadding(),
                start = dimensionResource(id = R.dimen.regularPadding),
                end = dimensionResource(
                    id = R.dimen.regularPadding
                )
            )
        ) {
            TitleField(postViewModel)
            AuthorField(postViewModel)
            ContentField(postViewModel)
        }
    }


}



@Composable
fun TitleField(postViewModel: PostViewModel) {
    TextFieldPost(
        modifier = Modifier.fillMaxWidth(),
        textValue = postViewModel.title,
        label = "Title",
        isNotValid = postViewModel.titleIsNotValid,
        supportText = "Invalid title",
        onTextChanged = { postViewModel.onChangeTitle(it) },
        maxLines = 2
    )
}

@Composable
fun AuthorField(postViewModel: PostViewModel){
    TextFieldPost(
        modifier = Modifier.fillMaxWidth(),
        textValue = postViewModel.author,
        label = "Author",
        isNotValid = postViewModel.authorIsNotValid,
        supportText = "Invalid author",
        onTextChanged = { postViewModel.onChangeAuthor(it) },
        maxLines = 2
    )
}

@Composable
fun ContentField(postViewModel: PostViewModel) {
    TextFieldPost(
        modifier = Modifier.fillMaxWidth(),
        textValue = postViewModel.content,
        label = "Content",
        isNotValid = postViewModel.contentIsNotValid,
        supportText = "Invalid content",
        onTextChanged = { postViewModel.onChangeContent(it) },
        minLines = 4,
        maxLines = 7
    )
}