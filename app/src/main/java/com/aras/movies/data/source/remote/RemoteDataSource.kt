package com.aras.movies.data.source.remote

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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

    fun getDiscoverMovies(): LiveData<ApiResponse<List<MovieItems>>> {
        EspressoIdlingResource.increment()
        val resultMovie = MutableLiveData<ApiResponse<List<MovieItems>>>()
        val client = ApiConfig.getApiService().getDiscoverMovie()
        client.enqueue(object : retrofit2.Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get Movie Success")
                    resultMovie.value = response.body()?.let {
                        ApiResponse.success(it.results)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultMovie
    }

    fun getDiscoverTvshow(): LiveData<ApiResponse<List<TvshowItems>>> {
        EspressoIdlingResource.increment()
        val resultTvshow = MutableLiveData<ApiResponse<List<TvshowItems>>>()
        val client = ApiConfig.getApiService().getDiscoverTvshow()
        client.enqueue(object : retrofit2.Callback<TvshowResponse> {
            override fun onResponse(
                call: Call<TvshowResponse>,
                response: Response<TvshowResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d(this@RemoteDataSource.toString(), "Get TV Success")
                    resultTvshow.value = response.body()?.let {
                        ApiResponse.success(it.results)
                    }
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvshowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
        return resultTvshow
    }
}