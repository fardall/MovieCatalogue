package com.example.moviecatalogue.ui.shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class ShowsViewModelTest {
    private lateinit var viewModel: ShowsViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Before
    fun setUp() {
        viewModel = ShowsViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyShows = DataDummy.generateDataShows()
        val shows = MutableLiveData<List<Film>>()
        shows.value = dummyShows

        `when`(filmRepository.getTvShows()).thenReturn(shows)
        val showEntities = viewModel.getTvShows().value
        verify(filmRepository).getTvShows()
        assertNotNull(showEntities)
        assertEquals(10, showEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}