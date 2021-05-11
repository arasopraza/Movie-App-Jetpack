package com.aras.movies.data.source.remote.response

import com.aras.movies.data.source.local.entity.TvshowEntity
import com.google.gson.annotations.SerializedName

data class TvshowResponse(

	@field:SerializedName("page")
	val page: Int,

	@field:SerializedName("total_pages")
	val totalPages: Int,

	@field:SerializedName("results")
	val results: List<TvshowEntity>,

	@field:SerializedName("total_results")
	val totalResults: Int
)