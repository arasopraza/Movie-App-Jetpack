package com.aras.movies.di

import android.content.Context
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.LocalDataSource
import com.aras.movies.data.source.local.room.MovieDatabase
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}