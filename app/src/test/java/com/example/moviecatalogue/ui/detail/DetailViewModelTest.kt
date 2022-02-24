package com.example.moviecatalogue.ui.detail

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

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

    private val dummyMovie = DataDummy.generateDataMovies()[0]
    private val dummyShow = DataDummy.generateDataShows()[0]
    private val dummyMovieTitle = dummyMovie.title
    private val dummyShowsTitle = dummyShow.title

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Film?>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(filmRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<Film?>()
        movie.value = dummyMovie

        `when`(filmRepository.getFilm(dummyMovieTitle)).thenReturn(movie)
        val movieEntites = viewModel.getFilm(dummyMovieTitle).value as Film
        verify(filmRepository).getFilm(dummyMovieTitle)
        assertNotNull(movieEntites)
        assertEquals(dummyMovie.title, movieEntites.title)
        assertEquals(dummyMovie.status, movieEntites.status)
        assertEquals(dummyMovie.originalLanguage, movieEntites.originalLanguage)
        assertEquals(dummyMovie.description, movieEntites.description)
        assertEquals(dummyMovie.casts, movieEntites.casts)
        assertEquals(dummyMovie.poster, movieEntites.poster)


        viewModel.getFilm(dummyMovieTitle).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getShow() {
        val show = MutableLiveData<Film>()
        show.value = dummyShow

        `when`(filmRepository.getFilm(dummyShowsTitle)).thenReturn(show)
        val movieEntites = viewModel.getFilm(dummyShowsTitle).value as Film
        verify(filmRepository).getFilm(dummyShowsTitle)
        assertNotNull(movieEntites)
        assertEquals(dummyShow.title, movieEntites.title)
        assertEquals(dummyShow.status, movieEntites.status)
        assertEquals(dummyShow.originalLanguage, movieEntites.originalLanguage)
        assertEquals(dummyShow.description, movieEntites.description)
        assertEquals(dummyShow.casts, movieEntites.casts)
        assertEquals(dummyShow.poster, movieEntites.poster)


        viewModel.getFilm(dummyShowsTitle).observeForever(observer)
        verify(observer).onChanged(dummyShow)
    }
}