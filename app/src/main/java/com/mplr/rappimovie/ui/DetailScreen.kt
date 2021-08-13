package com.mplr.rappimovie.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mplr.rappimovie.api.BASE_IMAGE_URL
import com.mplr.rappimovie.models.Movie
import com.mplr.rappimovie.navigation.DETAIL_MOVIE_ROUTE
import com.mplr.rappimovie.ui.theme.Typography
import com.mplr.rappimovie.ui.theme.White
import com.mplr.rappimovie.ui.theme.shimmerHighLight
import com.mplr.rappimovie.viewmodel.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreen(navController: NavController, mainViewModel: MainViewModel) {
    val movie = mainViewModel.getCurrentMovie()
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBar(title = movie.title.toString(), navController = navController, true)

            GlideImage(
                imageModel = "$BASE_IMAGE_URL${movie.poster_path}",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp),
                circularRevealedEnabled = true,
                // shows a shimmering effect when loading an image.
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = shimmerHighLight,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
                contentScale = ContentScale.Inside,
                failure = {
                    Text(text = "image request failed.")
                })

            DescriptionMovie(title = "Description", value = movie.overview.toString())
            DescriptionMovie(title = "Premier Date", value = movie.releaseDate.toString())
        }

        Button(
            onClick = {
                /*Watch Movie*/
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = White
            ),
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 32.dp)
                .fillMaxWidth()
                .height(36.dp)
                .align(Alignment.BottomCenter)

        ) {
            Text(text = "Ver Pelicula")
        }
    }

}

@Composable
fun DescriptionMovie(title: String, value: String) {
    Text(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp),
        text = title,
        style = Typography.h6
    )

    Text(
        modifier = Modifier
            .padding(top = 4.dp, start = 16.dp),
        text = value,
        style = Typography.body1
    )
}