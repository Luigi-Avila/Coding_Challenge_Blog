package com.luigidev.linkthread.features.post.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.post.domain.states.PostUIState
import com.luigidev.linkthread.features.post.domain.usecase.SavePostUseCase
import com.luigidev.linkthread.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val savePostUseCase: SavePostUseCase) :
    ViewModel() {

    internal var postUIState: PostUIState by mutableStateOf(PostUIState.FillOut)
        private set
    internal var title: String by mutableStateOf("")
        private set

    internal var content: String by mutableStateOf("")
        private set

    internal var author: String by mutableStateOf("")
        private set

    internal var titleIsNotValid: Boolean by mutableStateOf(false)
        private set
    internal var authorIsNotValid: Boolean by mutableStateOf(false)
        private set
    internal var contentIsNotValid: Boolean by mutableStateOf(false)
        private set

    private var isSubmitted = false

    fun onChangeTitle(text: String) {
        title = text
        titleIsNotValid = title.length <= 3 && isSubmitted
    }

    fun onChangeContent(text: String) {
        content = text
        contentIsNotValid = content.length <= 3 && isSubmitted
    }

    fun onChangeAuthor(text: String) {
        author = text
        authorIsNotValid = author.length <= 3 && isSubmitted
    }

    fun sendPost() {
        isSubmitted = true
        formatText()
        if (validateFields()) {
            val post = Post(
                title = title,
                author = author,
                dateTime = Calendar.getInstance().time.toString(),
                content = content
            )
            postUIState = PostUIState.Loading
            savePostUseCase(post) { result ->
                postUIState = when (result) {
                    is ResultAPI.Error -> PostUIState.Error(result.message)
                    is ResultAPI.Success -> PostUIState.Success
                }
            }
        }
    }

    private fun formatText() {
        title = title.trim()
        author = author.trim()
        content = content.trim()
    }

    fun resetPost() {
        postUIState = PostUIState.FillOut
        title = ""
        content = ""
        author = ""
        isSubmitted = false
    }

    fun goToHome(navController: NavController) {
        navController.navigate(Routes.HomeScreen.route)
        postUIState = PostUIState.FillOut
    }

    private fun validateFields(): Boolean {
        if (title.length <= 3) titleIsNotValid = true

        if (author.length <= 3) authorIsNotValid = true

        if (content.length <= 3) contentIsNotValid = true

        return title.length > 3 && author.length > 3 && content.length > 3
    }

}