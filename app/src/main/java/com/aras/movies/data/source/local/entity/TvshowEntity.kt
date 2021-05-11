package com.aras.movies.data.source.local.entity

import com.google.gson.annotations.SerializedName

data class TvshowEntity(

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
        val id: Int,

        @field:SerializedName("vote_count")
        val voteCount: Int
)