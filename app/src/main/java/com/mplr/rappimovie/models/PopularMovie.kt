package com.mplr.rappimovie.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class PopularMovie(
    val page: Int? = null,
    val totalResults: Int? = null,
    val totalPages: Int? = null,
    val results: MutableList<Movie> = arrayListOf(),
    var statusCode: Int = 0,
    var statusMessage: String? = null
) : Parcelable {}