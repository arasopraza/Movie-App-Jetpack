package com.aras.movies.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.remote.response.MovieItems

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(): LiveData<List<MovieItems>> = movieRepository.getDiscoverMovies()
}