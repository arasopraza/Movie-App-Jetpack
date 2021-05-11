package com.aras.movies.ui.tvshows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.TvshowEntity

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow() : LiveData<List<TvshowEntity>> = movieRepository.getDiscoverTvshow()
}