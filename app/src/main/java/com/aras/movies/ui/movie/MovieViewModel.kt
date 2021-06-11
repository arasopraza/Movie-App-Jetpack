package com.aras.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.vo.Resource

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = movieRepository.getDiscoverMovies()
}