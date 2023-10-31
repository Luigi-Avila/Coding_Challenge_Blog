package com.luigidev.linkthread

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.luigidev.linkthread.features.home.ui.HomeScreen
import com.luigidev.linkthread.features.home.ui.HomeViewModel
import com.luigidev.linkthread.ui.theme.LinkThreadTheme

class MainActivity : ComponentActivity() {

//    private val postViewModel: PostViewModel by viewModels()

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LinkThreadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                   PostScreen(postViewModel)
                    HomeScreen(homeViewModel)
                }
            }
        }
    }
}