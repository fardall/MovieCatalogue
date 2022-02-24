package com.example.moviecatalogue.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.utils.DataDummy
import org.junit.Assert.*
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
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<Film>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyMovies = DataDummy.generateDataMovies()
        val movies = MutableLiveData<List<Film>>()
        movies.value = dummyMovies

        `when`(filmRepository.getMovies()).thenReturn(movies)
        val movieEntities = viewModel.getMovies().value
        verify(filmRepository).getMovies()
        assertNotNull(movieEntities)
        assertEquals(10, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}