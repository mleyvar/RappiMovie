package com.mplr.rappimovie.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mplr.rappimovie.navigation.DETAIL_MOVIE_ROUTE
import com.mplr.rappimovie.navigation.MOVIE_ROUTE
import com.mplr.rappimovie.ui.theme.RappiMovieTheme
import com.mplr.rappimovie.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RappiMovieApp {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<MainViewModel>()

                NavHost(navController, startDestination = MOVIE_ROUTE) {

                    composable(route = MOVIE_ROUTE) {
                        MovieScreen(navController, viewModel)
                    }

                    composable(route = DETAIL_MOVIE_ROUTE) {
                        DetailScreen(navController, viewModel)
                    }
                }
            }
        }
    }
}


@Composable
fun RappiMovieApp(content: @Composable () -> Unit) {
    RappiMovieTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}