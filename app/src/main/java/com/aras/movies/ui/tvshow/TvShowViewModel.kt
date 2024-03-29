package com.aras.movies.ui.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.vo.Resource

class TvShowViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getTvShow() : LiveData<Resource<PagedList<TvshowEntity>>> = movieRepository.getDiscoverTvshows()
}