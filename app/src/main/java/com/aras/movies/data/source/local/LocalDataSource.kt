package com.aras.movies.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.local.room.MovieDao

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun insertMovie(movie: List<MovieEntity>) = mMovieDao.insertMovies(movie)
    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getAllMovies()
    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovie()
    fun getMovieDetail(movieId: Int): LiveData<MovieEntity> = mMovieDao.getDetailMovie(movieId)
    fun insertTvshow(tvshow: List<TvshowEntity>) = mMovieDao.insertTvshows(tvshow)
    fun getAllTvshows(): LiveData<List<TvshowEntity>> = mMovieDao.getAllTvshows()
    fun getFavoriteTvshow(): LiveData<List<TvshowEntity>> = mMovieDao.getFavoriteTvshow()
    fun getTvshowDetail(tvshowId: Int): LiveData<TvshowEntity> = mMovieDao.getDetailTvshow(tvshowId)

    fun setMovieFavorite(movie: MovieEntity, newState: Boolean) {
        movie.favorited = newState
        mMovieDao.updateMovie(movie)
    }

    fun setTvshowFavorite(tvshow: TvshowEntity, newState: Boolean) {
        tvshow.favorited = newState
        mMovieDao.updateTvshow(tvshow)
    }
}