package com.mplr.rappimovie.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
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
fun MovieScreen(navController: NavController, viewModel: MainViewModel) {
    viewModel.getPopularMovies(1)

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = "Rappi Movies", navController = navController, false)
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(viewModel.popularMovies.value.results) { movie ->
                MovieItem(movie, navController, viewModel)
            }
        }
    }
}

@Composable
fun MovieItem(movie: Movie, navController: NavController, viewModel: MainViewModel) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        elevation = 8.dp
    ) {
        Row {
            GlideImage(
                imageModel = "$BASE_IMAGE_URL${movie.poster_path}",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(100.dp),
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp),
                    text = movie.title.toString(),
                    style = Typography.h5
                )

                Text(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 16.dp),
                    text = "Rating: ${movie.vote_average}",
                    style = Typography.caption
                )

                Button(
                    onClick = {
                        viewModel.setCurrentMovie(movie)
                        navController.navigate(DETAIL_MOVIE_ROUTE)
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.primary,
                        contentColor = White
                    ),
                    modifier = Modifier
                        .padding(top = 32.dp, end = 20.dp, bottom = 16.dp)
                        .height(36.dp)
                        .align(Alignment.End)

                ) {
                    Text(text = "See Detail")
                }
            }
        }
    }
}
