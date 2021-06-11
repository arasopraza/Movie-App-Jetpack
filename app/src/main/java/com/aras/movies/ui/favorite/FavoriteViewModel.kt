package com.aras.movies.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getMovies(): LiveData<PagedList<MovieEntity>> = movieRepository.getFavoriteMovie()
    fun getTvshow(): LiveData<PagedList<TvshowEntity>> = movieRepository.getFavoriteTvshow()
}