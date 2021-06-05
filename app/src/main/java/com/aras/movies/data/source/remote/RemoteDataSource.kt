package com.aras.movies.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.aras.movies.data.source.remote.response.*
import com.aras.movies.networking.ApiConfig
import com.aras.movies.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Response

class RemoteDataSource {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getDiscoverMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDiscoverMovie()
        client.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Success")
                    callback.onAllMoviesReceived(response.body()?.results)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getDetailMovies(id: Int, callback: LoadDetailMovieCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovie(id)
        client.enqueue(object : retrofit2.Callback<MovieItems> {
            override fun onResponse(call: Call<MovieItems>, response: Response<MovieItems>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Success")
                    callback.onAllMoviesReceived(response.body())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieItems>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getDiscoverTvshow(callback: LoadTvshowsCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDiscoverTvshow()
        client.enqueue(object : retrofit2.Callback<TvshowResponse> {
            override fun onResponse(call: Call<TvshowResponse>, response: Response<TvshowResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get TV Success")
                    callback.onAllTvshowsReceived(response.body()?.results)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                    EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvshowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun getDetailTvshow(id: Int, callback: LoadDetailTvshowCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTvshow(id)
        client.enqueue(object : retrofit2.Callback<TvshowItems> {
            override fun onResponse(call: Call<TvshowItems>, response: Response<TvshowItems>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Success")
                    callback.onAllMoviesReceived(response.body())
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvshowItems>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieItems>?)
    }

    interface LoadDetailMovieCallback {
        fun onAllMoviesReceived(movieResponse: MovieItems?)
    }

    interface LoadTvshowsCallback {
        fun onAllTvshowsReceived(tvshowResponse: List<TvshowItems>?)
    }

    interface LoadDetailTvshowCallback {
        fun onAllMoviesReceived(tvshowResponse: TvshowItems?)
    }
}