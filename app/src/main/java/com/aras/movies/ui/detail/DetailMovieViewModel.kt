package com.aras.movies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import kotlin.properties.Delegates

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    var movieId by Delegates.notNull<Int>()
    var tvshowId by Delegates.notNull<Int>()

    fun selectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun selectedTvshow(tvshowId: Int) {
        this.tvshowId = tvshowId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepository.getDetailMovie(movieId)
    fun getTvshow(): LiveData<TvshowEntity> = movieRepository.getDetailTvshow(tvshowId)


    fun setMovieFavorite(movie: MovieEntity) {
        val newState = movie.favorited
        newState.let { movieRepository.setMovieFavorite(movie, it) }
    }

    fun setTvshowFavorite(tvshow: TvshowEntity) {
        val newState = tvshow.favorited
        newState.let { movieRepository.setTvshowFavorite(tvshow, it) }
    }
}
