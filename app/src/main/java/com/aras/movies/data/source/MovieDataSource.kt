package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

interface MovieDataSource {

    fun getDiscoverMovies(): LiveData<List<MovieEntity>>
    fun getDiscoverTvshow(): LiveData<List<TvshowEntity>>
}