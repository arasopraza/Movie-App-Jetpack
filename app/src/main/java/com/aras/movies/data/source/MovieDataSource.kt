package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.vo.Resource

interface MovieDataSource {
    fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDetailMovie(movieId: Int): LiveData<MovieEntity>
    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun setMovieFavorite(movie: MovieEntity, state: Boolean)
    fun getDiscoverTvshows(): LiveData<Resource<PagedList<TvshowEntity>>>
    fun getDetailTvshow(tvshowId: Int): LiveData<TvshowEntity>
    fun getFavoriteTvshow(): LiveData<PagedList<TvshowEntity>>
    fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean)
}