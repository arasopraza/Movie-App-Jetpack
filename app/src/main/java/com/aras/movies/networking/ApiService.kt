package com.aras.movies.networking

import com.aras.movies.data.source.remote.response.MovieResponse
import com.aras.movies.data.source.remote.response.TvshowResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("discover/movie?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDiscoverMovie(): Call<MovieResponse>

    @GET("discover/tv?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDiscoverTvshow(): Call<TvshowResponse>

}