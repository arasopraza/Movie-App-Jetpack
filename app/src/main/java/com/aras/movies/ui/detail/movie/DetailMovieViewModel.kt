package com.aras.movies.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import kotlin.properties.Delegates

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    private var movieId by Delegates.notNull<Int>()
    private var tvshowId by Delegates.notNull<Int>()

    fun selectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun selectedTvshow(tvshowId: Int) {
        this.tvshowId = tvshowId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepository.getDetailMovie(movieId)
    fun getTvshows(): LiveData<TvshowEntity> = movieRepository.getDetailTvshow(tvshowId)
}