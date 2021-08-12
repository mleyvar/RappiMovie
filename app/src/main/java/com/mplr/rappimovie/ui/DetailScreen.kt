package com.mplr.rappimovie.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mplr.rappimovie.api.BASE_IMAGE_URL
import com.mplr.rappimovie.models.Movie
import com.mplr.rappimovie.ui.theme.Typography
import com.mplr.rappimovie.ui.theme.shimmerHighLight
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DetailScreen(movie: Movie) {
    Column {
        GlideImage(
            imageModel = "$BASE_IMAGE_URL${movie.poster_path}",
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .padding(top = 8.dp),
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


        Text(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp),
            text = movie.overview.toString(),
            style = Typography.body1
        )
    }
}