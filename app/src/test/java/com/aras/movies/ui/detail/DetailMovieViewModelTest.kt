package com.aras.movies.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.utils.DataDummy
import com.aras.movies.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvshow = DataDummy.generateDummyTvshows()[0]
    private val movieId = dummyMovie.movieId
    private val tvshowId = dummyTvshow.tvshowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var observerMovie: Observer<MovieEntity>

    @Mock
    private lateinit var observerTvshow: Observer<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repository)
        viewModel.selectedMovie(movieId)
        viewModel.selectedTvshow(tvshowId)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(repository.getDetailMovie(movieId)).thenReturn(movie)

        val movieEntity = viewModel.getMovie().value as MovieEntity
        verify(repository).getDetailMovie(movieId)
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.posterPath, movieEntity.posterPath)

        viewModel.getMovie().observeForever(observerMovie)
        verify(observerMovie).onChanged(dummyMovie)
    }

    @Test
    fun getTvshow() {
        val tvshow = MutableLiveData<TvshowEntity>()
        tvshow.value = dummyTvshow

        `when`(repository.getDetailTvshow(tvshowId)).thenReturn(tvshow)
        val tvshowEntity = viewModel.getTvshow().value as TvshowEntity
        verify(repository).getDetailTvshow(tvshowId)
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.tvshowId, tvshowEntity.tvshowId)
        assertEquals(dummyTvshow.name, tvshowEntity.name)
        assertEquals(dummyTvshow.firstAirDate, tvshowEntity.firstAirDate)
        assertEquals(dummyTvshow.overview, tvshowEntity.overview)
        assertEquals(dummyTvshow.posterPath, tvshowEntity.posterPath)

        viewModel.getTvshow().observeForever(observerTvshow)
        verify(observerTvshow).onChanged(dummyTvshow)
    }
}