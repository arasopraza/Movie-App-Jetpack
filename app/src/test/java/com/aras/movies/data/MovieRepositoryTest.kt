package com.aras.movies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import com.aras.movies.data.source.local.LocalDataSource
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.utils.AppExecutors
import com.aras.movies.utils.DataDummy
import com.aras.movies.utils.LiveDataTestUtil
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
        val dummyMovies = MutableLiveData<List<MovieEntity>>()
        dummyMovies.value = DataDummy.generateDummyMovies()
        `when`(local.getAllMovies()).thenReturn(dummyMovies)

        val movieEntities = LiveDataTestUtil.getValue(repository.getDiscoverMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities.data)
        assertEquals(movieResponses.size.toLong(), movieEntities.data?.size?.toLong())
    }

    @Test
    fun getDiscoverTvshows() {
        val dummyTvshows = MutableLiveData<List<TvshowEntity>>()
        dummyTvshows.value = DataDummy.generateDummyTvshows()
        `when`(local.getAllTvshows()).thenReturn(dummyTvshows)

        val tvshowEntities = LiveDataTestUtil.getValue(repository.getDiscoverTvshows())
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
        val dummyMovie = MutableLiveData<List<MovieEntity>>()
        dummyMovie.value = DataDummy.generateDummyMovies()
        `when`(local.getFavoriteMovie()).thenReturn(dummyMovie)

        val movieEntities = LiveDataTestUtil.getValue(repository.getFavoriteMovie())
        verify(local).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getFavoriteTvshow() {
        val dummyTvshow = MutableLiveData<List<TvshowEntity>>()
        dummyTvshow.value = DataDummy.generateDummyTvshows()
        `when`(local.getFavoriteTvshow()).thenReturn(dummyTvshow)

        val tvshowEntities = LiveDataTestUtil.getValue(repository.getFavoriteTvshow())
        verify(local).getFavoriteTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.size.toLong())
    }
}