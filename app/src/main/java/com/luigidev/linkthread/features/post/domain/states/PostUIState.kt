package com.luigidev.linkthread.features.post.domain.states

sealed class PostUIState {
    data class Error(val message: String) : PostUIState()
    object Loading : PostUIState()
    object FillOut : PostUIState()
    object Success: PostUIState()
}
