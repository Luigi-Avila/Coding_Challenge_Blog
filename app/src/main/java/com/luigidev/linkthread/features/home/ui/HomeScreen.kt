package com.luigidev.linkthread.features.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luigidev.linkthread.features.home.domain.states.HomeUIState
import com.luigidev.linkthread.features.home.ui.states.HomeSuccessScreen

@Composable
fun HomeScreen(navController: NavHostController) {

    val homeViewModel = hiltViewModel<HomeViewModel>()

    when (homeViewModel.homeUIState) {
        is HomeUIState.Error -> {
            Text(text = "Error")
        }

        HomeUIState.Loading -> {
            Text(text = "Loading")
        }

        HomeUIState.Success -> {
            HomeSuccessScreen(homeViewModel, navController)
        }
    }

}

