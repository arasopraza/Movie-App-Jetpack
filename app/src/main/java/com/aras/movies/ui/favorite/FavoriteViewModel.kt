package com.aras.movies.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity

class FavoriteViewModel(private val movieRepository: MovieRepository): ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = movieRepository.getFavoriteMovie()

}