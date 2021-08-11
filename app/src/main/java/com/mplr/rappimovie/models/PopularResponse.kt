package com.mplr.rappimovie.models

import com.google.gson.annotations.SerializedName

data class PopularResponse
    (
    @SerializedName("page") val page: Int? = null,
    @SerializedName("total_results") val totalResults: Int? = null,
    @SerializedName("total_pages") val totalPages: Int? = null,
    @SerializedName("results") val results: MutableList<ResultMovie> = arrayListOf(),
    @SerializedName("status_code") var statusCode: Int = 0,
    @SerializedName("status_message") var statusMessage: String? = null
)