package com.aras.movies.di

import android.content.Context
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return MovieRepository.getInstance(remoteDataSource)
    }
}