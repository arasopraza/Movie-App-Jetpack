package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.TvshowItems

interface MovieDataSource {
    fun getDiscoverMovies(): LiveData<List<MovieItems>>
    fun getDetailMovie(movieId: Int): LiveData<MovieItems>
    fun getDiscoverTvshows(): LiveData<List<TvshowItems>>
    fun getDetailTvshow(tvshowId: Int): LiveData<TvshowItems>
}