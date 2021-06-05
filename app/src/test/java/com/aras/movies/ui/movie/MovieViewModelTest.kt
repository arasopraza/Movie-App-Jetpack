package com.aras.movies.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var observer: Observer<List<MovieItems>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(repository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.generateDummyMovies()
        val movie = MutableLiveData<List<MovieItems>>()
        movie.value = dummyMovie

        `when`(repository.getDiscoverMovies()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value
        verify(repository).getDiscoverMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}