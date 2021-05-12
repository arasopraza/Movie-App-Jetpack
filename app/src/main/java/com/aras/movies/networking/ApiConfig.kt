package com.aras.movies.networking

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {

//    private val httpClient = OkHttpClient.Builder().apply {
//    }.build()
//
//    private val retrofit: Retrofit.Builder by lazy {
//        Retrofit.Builder().apply {
//            client(httpClient)
//            baseUrl("https://api.themoviedb.org/3/")
//            addConverterFactory(GsonConverterFactory.create())
//        }
//    }
    companion object {
        fun getApiService(): ApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

//    val instance: ApiService by lazy {
//        retrofit
//            .build()
//            .create(ApiService::class.java)
//    }
}