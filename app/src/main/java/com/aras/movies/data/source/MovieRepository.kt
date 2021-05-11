package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.RemoteDataSource

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

    override fun getDiscoverMovies(): LiveData<List<MovieEntity>> {
        val movieResults = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getDiscoverMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(movieResponse: List<MovieEntity>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movieResponse != null) {
                    for (response in movieResponse) {
                        val movie = MovieEntity(
                            response.overview,
                            response.originalLanguage,
                            response.originalTitle,
                            response.title,
                            response.posterPath,
                            response.releaseDate,
                            response.popularity,
                            response.voteAverage,
                            response.id,
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

    override fun getDiscoverTvshow(): LiveData<List<TvshowEntity>> {
        val movieResults = MutableLiveData<List<TvshowEntity>>()
        remoteDataSource.getDiscoverTvshow(object : RemoteDataSource.LoadTvshowsCallback {
            override fun onAllTvshowsReceived(tvshowResponse: List<TvshowEntity>?) {
                val tvshowList = ArrayList<TvshowEntity>()
                if (tvshowResponse != null) {
                    for (response in tvshowResponse) {
                        val tvshow = TvshowEntity(
                            response.firstAirDate,
                            response.overview,
                            response.originalLanguage,
                            response.posterPath,
                            response.originalName,
                            response.popularity,
                            response.voteAverage,
                            response.name,
                            response.id,
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
}