package com.aras.movies.networking

import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.MovieResponse
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.data.source.remote.response.TvshowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("discover/movie?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDiscoverMovie(): Call<MovieResponse>

    @GET("movie/{movie_id}?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDetailMovie(@Path("movie_id") id: Int): Call<MovieItems>

    @GET("discover/tv?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDiscoverTvshow(): Call<TvshowResponse>

    @GET("tv/{tv_id}?api_key=d6a667ee46946b25455e52a30011b9a6")
    fun getDetailTvshow(@Path("tv_id") id: Int): Call<TvshowItems>
}
