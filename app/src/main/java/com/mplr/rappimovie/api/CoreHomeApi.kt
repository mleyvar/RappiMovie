package com.mplr.rappimovie.api

import com.mplr.rappimovie.models.PopularResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface CoreHomeApi {


    @GET(SERVICE_POPULAR)
    @Headers("Content-Type: application/json;charset=UTF-8")
    fun getPopularMovies(
        @Query(value = "api_key", encoded = true) api_key: String? = API_KEY,
        @Query(value = "page", encoded = true) page: Int
    ): Observable<PopularResponse>
}