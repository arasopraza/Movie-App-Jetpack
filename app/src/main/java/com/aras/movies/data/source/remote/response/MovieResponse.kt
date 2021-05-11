package com.aras.movies.data.source.remote.response

import com.aras.movies.data.source.local.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<MovieEntity>,

	@field:SerializedName("total_results")
	val totalResults: Int
)
