package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

interface MovieDataSource {
    fun getDiscoverMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>
    fun getDiscoverTvshows(): LiveData<List<TvshowEntity>>
    fun getDetailTvshow(tvshowId: Int): LiveData<TvshowEntity>
}