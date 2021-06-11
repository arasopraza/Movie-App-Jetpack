package com.aras.movies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.aras.movies.data.source.local.LocalDataSource
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.utils.AppExecutors
import com.aras.movies.utils.DataDummy
import com.aras.movies.utils.LiveDataTestUtil
import com.aras.movies.utils.PagedListUtil
import com.aras.movies.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val repository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val movieEntity = DataDummy.generateMovieById(movieId)

    private val tvshowResponses = DataDummy.generateDummyTvshows()
    private val tvshowId = tvshowResponses[0].tvshowId
    private val tvshowEntity = DataDummy.generateTvshowById(tvshowId)

    @Test
    fun getDiscoverMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        repository.getDiscoverMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDiscoverTvshows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getAllTvshows()).thenReturn(dataSourceFactory)
        repository.getDiscoverTvshows()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshows()))
        verify(local).getAllTvshows()
        assertNotNull(tvshowEntities.data)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovie() {
        val dummyMovie = MutableLiveData<MovieEntity>()
        dummyMovie.value = DataDummy.generateMovieById(movieId)
        `when`(local.getMovieDetail(movieId)).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(local).getMovieDetail(movieId)
        assertNotNull(movieEntities)
        assertEquals(movieEntity.originalTitle, movieEntities.originalTitle)
    }

    @Test
    fun getDetailTvshow() {
        val dummyTvshow = MutableLiveData<TvshowEntity>()
        dummyTvshow.value = DataDummy.generateTvshowById(tvshowId)
        `when`(local.getTvshowDetail(tvshowId)).thenReturn(dummyTvshow)

        val tvshowEntities = LiveDataTestUtil.getValue(repository.getDetailTvshow(tvshowId))
        verify(local).getTvshowDetail(tvshowId)
        assertNotNull(tvshowEntities)
        assertEquals(tvshowEntity.originalName, tvshowEntities.originalName)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        repository.getFavoriteMovie()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvshow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        `when`(local.getFavoriteTvshow()).thenReturn(dataSourceFactory)
        repository.getFavoriteTvshow()

        val tvshowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshows()))
        verify(local).getFavoriteTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.data?.size?.toLong())
    }
}