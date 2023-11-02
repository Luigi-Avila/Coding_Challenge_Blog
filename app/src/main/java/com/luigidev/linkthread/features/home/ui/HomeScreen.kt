package com.luigidev.linkthread.features.home.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luigidev.linkthread.core.ErrorScreen
import com.luigidev.linkthread.features.home.domain.states.HomeUIState
import com.luigidev.linkthread.features.home.ui.states.HomeSuccessScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavHostController) {

    val homeViewModel = hiltViewModel<HomeViewModel>()

    when (homeViewModel.homeUIState) {
        is HomeUIState.Error -> {
            ErrorScreen()
        }

        HomeUIState.Loading -> {
            Box(contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }

        HomeUIState.Success -> {
            HomeSuccessScreen(homeViewModel, navController)
        }
    }

}

