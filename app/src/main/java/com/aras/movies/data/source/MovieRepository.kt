package com.aras.movies.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aras.movies.data.NetworkBoundResource
import com.aras.movies.data.source.local.LocalDataSource
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.ApiResponse
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.utils.AppExecutors
import com.aras.movies.vo.Resource

class MovieRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieDataSource {

    companion object {
        @Volatile
        private var instance: MovieRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieRepository =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }

    override fun getDiscoverMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MovieItems>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MovieItems>>> =
                remoteDataSource.getDiscoverMovies()

            override fun saveCallResult(data: List<MovieItems>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.movieId,
                        response.title,
                        response.originalTitle,
                        response.originalLanguage,
                        response.releaseDate,
                        response.overview,
                        response.posterPath,
                        response.popularity,
                        response.voteAverage,
                        response.voteCount
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDiscoverTvshows(): LiveData<Resource<PagedList<TvshowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvshowEntity>, List<TvshowItems>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvshowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvshows(), config).build()
        }

            override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvshowItems>>> =
                remoteDataSource.getDiscoverTvshow()

            override fun saveCallResult(data: List<TvshowItems>) {
                val tvshowList = ArrayList<TvshowEntity>()
                for (response in data) {
                    val tvshow = TvshowEntity(
                        response.tvshowId,
                        response.name,
                        response.originalName,
                        response.originalLanguage,
                        response.firstAirDate,
                        response.overview,
                        response.posterPath,
                        response.popularity,
                        response.voteAverage,
                        response.voteCount
                    )
                    tvshowList.add(tvshow)
                }
                localDataSource.insertTvshow(tvshowList)
            }
        }.asLiveData()
    }


    override fun getDetailMovie(movieId: Int): LiveData<MovieEntity> {
        return localDataSource.getMovieDetail(movieId)
    }

    override fun getDetailTvshow(tvshowId: Int): LiveData<TvshowEntity> {
        return localDataSource.getTvshowDetail(tvshowId)
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun setMovieFavorite(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setMovieFavorite(movie, state) }

    override fun getFavoriteTvshow(): LiveData<PagedList<TvshowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvshow(), config).build()
    }

    override fun setTvshowFavorite(tvshow: TvshowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setTvshowFavorite(tvshow, state) }
    }
}

