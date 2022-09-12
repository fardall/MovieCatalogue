package com.example.moviecatalogue.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film
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
class FavoriteViewModelTest {
    private lateinit var viewModel: FavoriteViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<PagedList<Film>>

    @Mock
    private lateinit var pagedList: PagedList<Film>

    @Before
    fun setUp() {
        viewModel = FavoriteViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(1)
        val movies = MutableLiveData<PagedList<Film>>()
        movies.value = dummyMovies

        `when`(filmRepository.getFavMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        verify(filmRepository).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(1, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }

    @Test
    fun getShows() {
        val dummyShows = pagedList
        `when`(dummyShows.size).thenReturn(1)
        val shows = MutableLiveData<PagedList<Film>>()
        shows.value = dummyShows

        `when`(filmRepository.getFavShows()).thenReturn(shows)
        val showEntities = viewModel.getTvShows().value
        verify(filmRepository).getFavShows()
        assertNotNull(showEntities)
        assertEquals(1, showEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}