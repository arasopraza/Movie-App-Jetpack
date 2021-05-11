//package com.aras.movies.ui.tvshows
//
//import com.aras.movies.utils.DataDummy
//import org.junit.Before
//import org.junit.Test
//
//import org.junit.Assert.*
//import org.mockito.Mockito.*
//
//class TvShowViewModelTest {
//
//    private lateinit var viewModel: TvShowViewModel
//    private val dummyTvshow = DataDummy.generateDummyTvshows()
//
//    @Before
//    fun setUp() {
//        viewModel = mock(TvShowViewModel::class.java)
//    }
//
//    @Test
//    fun getTvShow() {
//        `when`(viewModel.getTvShow()).thenReturn(dummyTvshow)
//        val tvshow = viewModel.getTvShow()
//        verify(viewModel).getTvShow()
//        assertEquals(dummyTvshow, tvshow)
//    }
//}