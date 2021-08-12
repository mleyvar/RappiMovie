package com.mplr.rappimovie.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mplr.rappimovie.api.BASE_IMAGE_URL
import com.mplr.rappimovie.models.Movie
import com.mplr.rappimovie.ui.theme.Typography
import com.mplr.rappimovie.ui.theme.White
import com.mplr.rappimovie.ui.theme.shimmerHighLight
import com.mplr.rappimovie.viewmodel.MainViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MovieScreen() {
    val viewModel = hiltViewModel<MainViewModel>()
    viewModel.getPopularMovies(1)

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(viewModel.popularMovies.value.results) { movie ->
                MovieItem(movie)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Column {
            GlideImage(
                imageModel = "$BASE_IMAGE_URL${movie.poster_path}",
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp),
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

            Text(
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp),
                text = movie.title.toString(),
                style = Typography.h6
            )

            Text(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp),
                text = movie.releaseDate.toString(),
                style = Typography.caption
            )

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = White
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(40.dp)

            ) {
                Text(text = "Ver detalle")
            }
        }
    }
}
