package com.aras.movies.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aras.movies.data.source.remote.RemoteDataSource
import com.aras.movies.utils.DataDummy
import com.aras.movies.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val repository = FakeMovieRepository(remote)

    private val movieResponses = DataDummy.generateDummyMovies()
    private val movieId = movieResponses[0].movieId
    private val movieEntity = DataDummy.generateMovieById(movieId)

    private val tvshowResponses = DataDummy.generateDummyTvshows()
    private val tvshowId = tvshowResponses[0].tvshowId
    private val tvshowEntity = DataDummy.generateTvshowById(tvshowId)

    @Test
    fun getDiscoverMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getDiscoverMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getDiscoverMovies())
        verify(remote).getDiscoverMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDiscoverTvshows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvshowsCallback)
                .onAllTvshowsReceived(tvshowResponses)
            null
        }.`when`(remote).getDiscoverTvshow(any())
        val tvshowEntities = LiveDataTestUtil.getValue(repository.getDiscoverTvshows())
        verify(remote).getDiscoverTvshow(any())
        assertNotNull(tvshowEntities)
        assertEquals(tvshowResponses.size.toLong(), tvshowEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailMovieCallback)
                .onAllMoviesReceived(movieEntity)
            null
        }.`when`(remote).getDetailMovies(eq(movieId), any())

        val movieResult = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))
        verify(remote).getDetailMovies(eq(movieId), any())
        assertNotNull(movieResult)
        assertEquals(movieEntity.originalTitle, movieResult.originalTitle)
    }

    @Test
    fun getDetailTvshow() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.LoadDetailTvshowCallback)
                .onAllMoviesReceived(tvshowEntity)
            null
        }.`when`(remote).getDetailTvshow(eq(tvshowId), any())

        val tvshowResult = LiveDataTestUtil.getValue(repository.getDetailTvshow(tvshowId))
        verify(remote).getDetailTvshow(eq(tvshowId), any())
        assertNotNull(tvshowResult)
        assertEquals(tvshowEntity.originalName, tvshowResult.originalName)
    }
}