package com.mplr.rappimovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.mplr.rappimovie.ui.theme.RappiMovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RappiMovieApp()
        }
    }
}


@Composable
fun RappiMovieApp() {
    RappiMovieTheme {
        Surface(color = MaterialTheme.colors.background) {
            MovieScreen()
        }
    }
}