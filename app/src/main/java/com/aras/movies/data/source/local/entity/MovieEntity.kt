package com.aras.movies.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(

        @ColumnInfo(name = "overview")
        val overview: String,

//        val originalLanguage: String,
//
//        val originalTitle: String,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "poster_path")
        val posterPath: String,

        @ColumnInfo(name = "release_date")
        val releaseDate: String,

//        val popularity: Double,
//
//        val voteAverage: Double,

        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        val movieid: Int

//        val voteCount: Int
)