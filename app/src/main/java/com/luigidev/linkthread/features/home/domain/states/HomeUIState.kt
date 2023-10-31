package com.luigidev.linkthread.features.home.domain.states

sealed class HomeUIState{
    data class Error(val message: String): HomeUIState()
    object Success: HomeUIState()
    object Loading: HomeUIState()
}
