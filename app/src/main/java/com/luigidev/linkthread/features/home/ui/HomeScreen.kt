package com.luigidev.linkthread.features.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.luigidev.linkthread.features.home.domain.states.HomeUIState
import com.luigidev.linkthread.features.home.ui.states.HomeSuccessScreen

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavHostController) {
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

