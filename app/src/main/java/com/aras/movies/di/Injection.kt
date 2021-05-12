package com.aras.movies.di

import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }
}