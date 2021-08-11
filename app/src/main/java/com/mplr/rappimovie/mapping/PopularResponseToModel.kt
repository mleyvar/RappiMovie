package com.mplr.rappimovie.mapping

import com.mplr.rappimovie.models.Movie
import com.mplr.rappimovie.models.PopularMovie
import com.mplr.rappimovie.models.PopularResponse
import com.mplr.rappimovie.models.ResultMovie

internal fun PopularResponse.toModel(): PopularMovie {
    return PopularMovie(
        page,
        totalResults,
        totalPages,
        apiMoviesToModel(results),
        statusCode,
        statusMessage
    )
}

internal fun apiMoviesToModel(hits: MutableList<ResultMovie>): MutableList<Movie> {
    val listMovies: MutableList<Movie> = arrayListOf()

    hits.map { resultMovie ->
        listMovies.add(
            Movie(
                resultMovie.vote_count,
                resultMovie.id,
                resultMovie.video,
                resultMovie.vote_average,
                resultMovie.title,
                resultMovie.popularity,
                resultMovie.poster_path,
                resultMovie.original_language,
                resultMovie.original_title,
                resultMovie.backdropPath,
                resultMovie.adult,
                resultMovie.overview,
                resultMovie.releaseDate,
                resultMovie.page,
                resultMovie.image,
                resultMovie.type

            )
        )
    }
    return listMovies
}

