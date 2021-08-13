package com.mplr.rappimovie.repositories

import com.mplr.rappimovie.api.CoreHomeApi
import com.mplr.rappimovie.mapping.toModel
import com.mplr.rappimovie.models.Movie
import com.mplr.rappimovie.models.PopularMovie
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    private lateinit var currentMovie: Movie

    fun getPopularMovies( page: Int  ): Observable<PopularMovie>{
        return apiService.getPopularMovies(
            page = page  )
            .map {popularResponse ->
                popularResponse.toModel()
            }
    }

    fun setCurrentMovie(movie: Movie) {
        this.currentMovie = movie
    }

    fun getCurrentMovie() = currentMovie

}