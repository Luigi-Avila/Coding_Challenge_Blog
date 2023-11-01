package com.luigidev.linkthread.features.home.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luigidev.linkthread.core.ResultAPI
import com.luigidev.linkthread.core.models.Post
import com.luigidev.linkthread.features.home.domain.states.HomeUIState
import com.luigidev.linkthread.features.home.domain.usecase.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getPostsUseCase: GetPostsUseCase) :
    ViewModel() {

    internal var homeUIState: HomeUIState by mutableStateOf(HomeUIState.Loading)
        private set

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private var _posts = MutableStateFlow(emptyList<Post>())
    val posts = searchText.combine(_posts) { text, posts ->
        if (text.isBlank()) {
            posts
        } else {
            posts.filter {
                it.matchSearchQuery(text)
            }
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        _posts.value,
    )

    init {
        getPosts()
    }

    private fun getPosts() {
        homeUIState = HomeUIState.Loading
        getPostsUseCase { result ->
            homeUIState = when (result) {
                is ResultAPI.Error -> HomeUIState.Error(result.message)
                is ResultAPI.Success -> {
                    _posts.value = result.data
                    HomeUIState.Success
                }
            }
        }
    }

    fun onChangeSearchText(text: String) {
        _searchText.value = text
    }

}