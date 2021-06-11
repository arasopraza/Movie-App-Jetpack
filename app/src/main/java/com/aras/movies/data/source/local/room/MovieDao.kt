package com.aras.movies.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movie: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteMovies(movie: List<MovieEntity>)

    @Update
    fun updateMovie(movieEntity: MovieEntity)

    @Query("SELECT * FROM movie_entities")
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities where favorited = 1")
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM movie_entities WHERE movieId = :movieId")
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTvshows(tvshow: List<TvshowEntity>)

    @Update
    fun updateTvshow(tvshowEntity: TvshowEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoriteTvshows(tvshow: List<TvshowEntity>)

    @Query("SELECT * FROM tvshow_entities")
    fun getAllTvshows(): DataSource.Factory<Int, TvshowEntity>

    @Query("SELECT * FROM tvshow_entities where favorited = 1")
    fun getFavoriteTvshow(): DataSource.Factory<Int, TvshowEntity>

    @Query("SELECT * FROM tvshow_entities WHERE tvshowId = :tvshowId")
    fun getDetailTvshow(tvshowId: Int): LiveData<TvshowEntity>
}