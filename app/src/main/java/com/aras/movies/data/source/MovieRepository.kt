package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.TvshowItems

class MovieRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData).apply { instance = this }
            }
    }

    override fun getDiscoverMovies(): LiveData<List<MovieItems>> {
        val movieResults = MutableLiveData<List<MovieItems>>()
        remoteDataSource.getDiscoverMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieItems>?) {
                val movieList = ArrayList<MovieItems>()
                if (movieResponse != null) {
                    for (response in movieResponse) {
                        val movie = MovieItems(
                            response.overview,
                            response.originalLanguage,
                            response.originalTitle,
                            response.title,
                            response.posterPath,
                            response.releaseDate,
                            response.popularity,
                            response.voteAverage,
                            response.movieId,
                            response.voteCount
                        )
                        movieList.add(movie)
                    }
                }
                movieResults.postValue(movieList)
            }
        })
        return movieResults
    }

    override fun getDiscoverTvshows(): LiveData<List<TvshowItems>> {
        val movieResults = MutableLiveData<List<TvshowItems>>()
        remoteDataSource.getDiscoverTvshow(object : RemoteDataSource.LoadTvshowsCallback {
            override fun onAllTvshowsReceived(tvshowResponse: List<TvshowItems>?) {
                val tvshowList = ArrayList<TvshowItems>()
                if (tvshowResponse != null) {
                    for (response in tvshowResponse) {
                        val tvshow = TvshowItems(
                            response.firstAirDate,
                            response.overview,
                            response.originalLanguage,
                            response.posterPath,
                            response.originalName,
                            response.popularity,
                            response.voteAverage,
                            response.name,
                            response.tvshowId,
                            response.voteCount
                        )
                        tvshowList.add(tvshow)
                    }
                }
                movieResults.postValue(tvshowList)
            }
        })
        return movieResults
    }

    override fun getDetailMovie(movieId: Int): LiveData<MovieItems> {
        val movieResults = MutableLiveData<MovieItems>()
        remoteDataSource.getDiscoverMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieItems>?) {
                lateinit var movie: MovieItems
                if (movieResponse != null) {
                    for (response in movieResponse) {
                        if (response.movieId == movieId) {
                            movie = MovieItems(
                                response.overview,
                                response.originalLanguage,
                                response.originalTitle,
                                response.title,
                                response.posterPath,
                                response.releaseDate,
                                response.popularity,
                                response.voteAverage,
                                response.movieId,
                                response.voteCount
                            )
                        }
                    }
                }
                movieResults.postValue(movie)
            }
        })
        return movieResults
    }

    override fun getDetailTvshow(tvshowId: Int): LiveData<TvshowItems> {
        val tvshowResults = MutableLiveData<TvshowItems>()
        remoteDataSource.getDiscoverTvshow(object : RemoteDataSource.LoadTvshowsCallback {
            override fun onAllTvshowsReceived(tvshowResponse: List<TvshowItems>?) {
                lateinit var tvshow: TvshowItems
                if (tvshowResponse != null) {
                    for (response in tvshowResponse) {
                        if (response.tvshowId == tvshowId) {
                            tvshow = TvshowItems(
                                response.firstAirDate,
                                response.overview,
                                response.originalLanguage,
                                response.posterPath,
                                response.originalName,
                                response.popularity,
                                response.voteAverage,
                                response.name,
                                response.tvshowId,
                                response.voteCount
                            )
                        }
                    }
                }
                tvshowResults.postValue(tvshow)
            }
        })
        return tvshowResults
    }
}