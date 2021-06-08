package com.aras.movies.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tvshow_entities")
data class TvshowEntity(

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "tvshowId")
    val tvshowId: Int,

    @ColumnInfo(name = "title")
    val name: String,

    @ColumnInfo(name = "original_name")
    val originalName: String,

    @ColumnInfo(name = "original_language")
    val originalLanguage: String,

    @ColumnInfo(name = "release_date")
    val firstAirDate: String,

    @ColumnInfo(name = "overview")
    val overview: String,

    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @ColumnInfo(name = "popularity")
    val popularity: Double,

    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @ColumnInfo(name = "vote_count")
    val voteCount: Int,

    @ColumnInfo(name = "favorited")
    var favorited: Boolean = false
)