package com.mplr.rappimovie.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.mplr.rappimovie.ui.theme.RappiMovieTheme
import com.mplr.rappimovie.viewmodel.MainViewModel
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
    val viewModel = hiltViewModel<MainViewModel>()
    viewModel.getPopularMovies(1)

    RappiMovieTheme {
        Surface(color = MaterialTheme.colors.background) {
            viewModel.popularMovies.observe(LocalLifecycleOwner.current) {

                Toast.makeText(this, "Data Here:" + it.results.size, Toast.LENGTH_SHORT).show()
                // para ver la imagen concatena  ( Const.BASE_IMAGE_URL + poster_path ) del objeto Movie
            }
        }
    }
}