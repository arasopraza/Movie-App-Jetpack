package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.vo.Resource

interface MovieDataSource {
    fun getDiscoverMovies(): LiveData<Resource<List<MovieEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>
    fun getFavoriteMovie(): LiveData<List<MovieEntity>>
    fun setMovieFavorite(movie: MovieEntity, state: Boolean)
    fun getDiscoverTvshows(): LiveData<Resource<List<TvshowEntity>>>
    fun getDetailTvshow(tvshowId: Int): LiveData<TvshowEntity>
    fun getFavoriteTvshow(): LiveData<List<TvshowEntity>>
    fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean)
}