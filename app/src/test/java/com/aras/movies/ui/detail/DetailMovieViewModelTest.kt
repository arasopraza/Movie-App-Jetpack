//package com.aras.movies.ui.detail
//
//import com.aras.movies.utils.DataDummy
//import org.junit.Before
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.mockito.Mockito.*
//
//class DetailMovieViewModelTest {
//
//    private lateinit var viewModel: DetailMovieViewModel
//    private val dummyMovie = DataDummy.generateDummyMovies()[0]
//    private val movieId = dummyMovie.movieId
//
//    @Before
//    fun setUp() {
//        viewModel = mock(DetailMovieViewModel::class.java)
//        viewModel.selectedMovie(movieId)
//    }
//
//    @Test
//    fun getMovies() {
//        `when`(viewModel.getMovies()).thenReturn(dummyMovie)
//        viewModel.selectedMovie(dummyMovie.movieId)
//        val movie = viewModel.getMovies()
//        verify(viewModel).getMovies()
//        assertNotNull(movie)
//        assertEquals(movie.movieId, movie.movieId)
//        assertEquals(dummyMovie.title, movie.title)
//        assertEquals(dummyMovie.release, movie.release)
//        assertEquals(dummyMovie.description, movie.description)
//        assertEquals(dummyMovie.imagePath, movie.imagePath)
//    }
//}