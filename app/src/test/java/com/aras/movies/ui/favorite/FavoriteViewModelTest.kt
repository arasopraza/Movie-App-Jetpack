package com.aras.movies.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<List<MovieEntity>>

    @Mock
    private lateinit var observerTvshow: Observer<List<TvshowEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(movieRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovie = DataDummy.generateDummyMovies()
        val movie = MutableLiveData<List<MovieEntity>>()
        movie.value = dummyMovie

        `when`(movieRepository.getFavoriteMovie()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value
        verify(movieRepository).getFavoriteMovie()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getTvshow() {
        val dummyTvshow = DataDummy.generateDummyTvshows()
        val tvshow = MutableLiveData<List<TvshowEntity>>()
        tvshow.value = dummyTvshow

        `when`(movieRepository.getFavoriteTvshow()).thenReturn(tvshow)
        val tvshowEntities = viewModel.getTvshow().value
        verify(movieRepository).getFavoriteTvshow()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities?.size)

        viewModel.getTvshow().observeForever(observerTvshow)
        verify(observerTvshow).onChanged(dummyTvshow)
    }
}