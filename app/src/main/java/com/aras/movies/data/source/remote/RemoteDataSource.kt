package com.aras.movies.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.response.MovieResponse
import com.aras.movies.data.source.remote.response.TvshowResponse
import com.aras.movies.networking.ApiConfig
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
        val client = ApiConfig.getApiService().getDiscoverMovie()
        client.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Success")
                    callback.onAllMoviesReceived(response.body()?.results)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }


    fun getDiscoverTvshow(callback: LoadTvshowsCallback) {
        val client = ApiConfig.getApiService().getDiscoverTvshow()
        client.enqueue(object : retrofit2.Callback<TvshowResponse> {
            override fun onResponse(call: Call<TvshowResponse>, response: Response<TvshowResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get TV Success")
                    callback.onAllTvshowsReceived(response.body()?.results)
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TvshowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    interface LoadMoviesCallback {
        fun onAllMoviesReceived(movieResponse: List<MovieEntity>?)
    }

    interface LoadTvshowsCallback {
        fun onAllTvshowsReceived(tvshowResponse: List<TvshowEntity>?)
    }
}