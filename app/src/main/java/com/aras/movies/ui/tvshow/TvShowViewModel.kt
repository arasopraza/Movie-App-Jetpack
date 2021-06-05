package com.aras.movies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.remote.response.TvshowItems

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow() : LiveData<List<TvshowItems>> = movieRepository.getDiscoverTvshows()
}