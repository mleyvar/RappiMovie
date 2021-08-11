package com.mplr.rappimovie.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Movie(
    var vote_count: Int? = null,
    val id: Int? = null,
    val video: Boolean? = null,
    val vote_average: Double? = null,
    val title: String? = null,
    val popularity: Double? = null,
    val poster_path: String? = null,
    val original_language: String? = null,
    val original_title: String? = null,
    val backdropPath: String? = null,
    val adult: Boolean? = null,
    val overview: String? = null,
    val releaseDate: String? = null,
    val page: Int = 0,
    var image: ByteArray? = null,
    var type: Int = 0
) : Parcelable {}