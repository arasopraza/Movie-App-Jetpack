package com.aras.movies.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.aras.movies.data.source.MovieRepository
import com.aras.movies.data.source.local.entity.TvshowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<List<TvshowEntity>>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repository)
    }

    @Test
    fun getTvShow() {
        val dummyTvshow = Resource.success(DataDummy.generateDummyTvshows())
        val tvshow = MutableLiveData<Resource<List<TvshowEntity>>>()
        tvshow.value = dummyTvshow

        `when`(repository.getDiscoverTvshows()).thenReturn(tvshow)
        val tvshowEntities = viewModel.getTvShow().value?.data
        verify(repository).getDiscoverTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(10, tvshowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}