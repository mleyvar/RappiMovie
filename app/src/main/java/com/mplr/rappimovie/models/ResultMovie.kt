package com.mplr.rappimovie.models

import com.google.gson.annotations.SerializedName

data class ResultMovie(
    @SerializedName("vote_count") var vote_count: Int? = null,
    @SerializedName("id") val id: Int? = null,
    @SerializedName("video") val video: Boolean? = null,
    @SerializedName("vote_average") val vote_average: Double? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("popularity") val popularity: Double? = null,
    @SerializedName("poster_path") val poster_path: String? = null,
    @SerializedName("original_language") val original_language: String? = null,
    @SerializedName("original_title") val original_title: String? = null,
    @SerializedName("backdrop_path") val backdropPath: String? = null,
    @SerializedName("adult") val adult: Boolean? = null,
    @SerializedName("overview") val overview: String? = null,
    @SerializedName("release_date") val releaseDate: String? = null,
    @SerializedName("page") val page: Int = 0,
    @SerializedName("ByteArray") var image: ByteArray? = null,
    @SerializedName("type") var type: Int = 0

)