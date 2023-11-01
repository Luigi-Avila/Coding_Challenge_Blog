package com.luigidev.linkthread.features.post.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.post.domain.states.PostUIState
import com.luigidev.linkthread.features.post.domain.usecase.SavePostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val savePostUseCase: SavePostUseCase) : ViewModel() {

    internal var postUIState: PostUIState by mutableStateOf(PostUIState.FillOut)
        private set
    internal var title: String by mutableStateOf("")
        private set

    internal var content: String by mutableStateOf("")
        private set


    fun onChangeTitle(text: String){
        title = text
    }

    fun onChangeContent(text: String){
        content = text
    }

    fun sendPost(){
        val post = Post(title = title, author = "Luigi", dateTime = Calendar.getInstance().time.toString(), content = content)
        postUIState = PostUIState.Loading
        savePostUseCase(post){ result ->
            postUIState = when(result){
                is ResultAPI.Error -> PostUIState.Error(result.message)
                is ResultAPI.Success -> PostUIState.Success
            }
        }

    }

    fun resetPost(){
        postUIState = PostUIState.FillOut
        title = ""
        content = ""
    }

}