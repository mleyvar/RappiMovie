package com.mplr.rappimovie.repositories

import com.mplr.rappimovie.api.CoreHomeApi
import com.mplr.rappimovie.mapping.toModel
import com.mplr.rappimovie.models.PopularMovie
import io.reactivex.Observable
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val apiService: CoreHomeApi
) {

    fun getPopularMovies( page: Int  ): Observable<PopularMovie>{
        return apiService.getPopularMovies(
            page = page  )
            .map {popularResponse ->
                popularResponse.toModel()
            }
    }

}