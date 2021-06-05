package com.aras.movies.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class TvshowResponse(
    @field:SerializedName("page")
    val page: Int,

    @field:SerializedName("total_pages")
    val totalPages: Int,

    @field:SerializedName("results")

    val results: List<TvshowItems>,

    @field:SerializedName("total_results")
    val totalResults: Int
)

@Parcelize
data class TvshowItems(
    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("overview")
    val overview: String,

	@field:SerializedName("original_language")
	val originalLanguage: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

	@field:SerializedName("original_name")
	val originalName: String,

	@field:SerializedName("popularity")
	val popularity: Double,

	@field:SerializedName("vote_average")
	val voteAverage: Double,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val tvshowId: Int,

	@field:SerializedName("vote_count")
	val voteCount: Int
) : Parcelable
