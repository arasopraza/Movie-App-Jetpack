package com.aras.movies.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "tvshow_entities")
data class TvshowEntity(

        @ColumnInfo(name = "release_date")
        val firstAirDate: String,

        @ColumnInfo(name = "overview")
        val overview: String,

//        val originalLanguage: String,

        @ColumnInfo(name = "poster_path")
        val posterPath: String,

//        val originalName: String,
//
//        val popularity: Double,

//        val voteAverage: Double,

        @ColumnInfo(name = "title")
        val name: String,

        @ColumnInfo(name = "tvshowId")
        val tvshowId: Int

//        val voteCount: Int
)