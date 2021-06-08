package com.aras.movies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.vo.Resource
import kotlin.properties.Delegates

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    //    val movieId = MutableLiveData<Int>()
//    val tvshowId = MutableLiveData<Int>()
    var movieId by Delegates.notNull<Int>()
    var tvshowId by Delegates.notNull<Int>()
//    lateinit var tvshowId: String

    fun selectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun selectedTvshow(tvshowId: Int) {
        this.tvshowId = tvshowId
    }

    fun getMovie(): LiveData<MovieEntity> = movieRepository.getDetailMovie(movieId)
    fun getTvshow(): LiveData<TvshowEntity> = movieRepository.getDetailTvshow(tvshowId)

//    fun selectedTvshow(tvshowId: Int) {
//        this.movieId.value = tvshowId
//    }

//    var movie: LiveData<MovieEntity> = Transformations.switchMap(movieId) { mMovieId ->
//        movieRepository.getDetailMovie(mMovieId)
//    }
//
//    var tvshow: LiveData<TvshowEntity> = Transformations.switchMap(tvshowId) { mTvshowId ->
//        movieRepository.getDetailTvshow(mTvshowId)
//    }

    fun setMovieFavorite() {
        val movie = getMovie().value
        val newState = movie?.favorited
        if (movie != null) {
            newState?.let { movieRepository.setMovieFavorite(movie, it) }
        }
    }

//    fun setTvshowFavorite(tvshow: TvshowEntity) {
//        val newState = tvshow.favorited
//        movieRepository.setTvshowFavorite(tvshow, newState)
//    }
}
