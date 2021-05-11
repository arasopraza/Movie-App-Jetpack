package com.aras.movies.ui.detail

import androidx.lifecycle.ViewModel
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity

class DetailMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
//    private lateinit var movieId: Int
//    private lateinit var tvshowId: String
//
//    fun selectedMovie(movieId: Int) {
//        this.movieId = movieId
//    }
//
//    fun getMovies(): MovieEntity {
//        lateinit var movie: MovieEntity
//        val movieEntities = DataDummy.generateDummyMovies()
//
//        for(movieEntity in movieEntities)  {
//            if (movieEntity.id == movieId) {
//                movie = movieEntity
//            }
//        }
//        return movie
//    }
//
//    fun selectedTvshow(tvshowId: String) {
//        this.tvshowId = tvshowId
//    }
//
//    fun getTvshows(): TvshowEntity {
//        lateinit var tvshow: TvshowEntity
//        val tvshowEntities = DataDummy.generateDummyTvshows()
//
//        for(tvshowEntity in tvshowEntities)  {
//            if (tvshowEntity.tvshowId == tvshowId) {
//                tvshow = tvshowEntity
//            }
//        }
//        return tvshow
//    }
}