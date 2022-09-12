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
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel

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
    fun getFilmMovie() {
        val dummyMovie = DataDummy.generateDataMovies()[0]
        val dummyMovieTitle = dummyMovie.title
        val movie = MutableLiveData<Film>()
        movie.value = dummyMovie

        `when`(filmRepository.getFilm(dummyMovieTitle)).thenReturn(movie)
        val movieEntites = viewModel.getFilm(dummyMovieTitle)?.value
        verify(filmRepository).getFilm(dummyMovieTitle)

        assertNotNull(movieEntites)
        assertEquals(dummyMovie.title, movieEntites?.title)
        assertEquals(dummyMovie.status, movieEntites?.status)
        assertEquals(dummyMovie.originalLanguage, movieEntites?.originalLanguage)
        assertEquals(dummyMovie.description, movieEntites?.description)
        assertEquals(dummyMovie.casts, movieEntites?.casts)
        assertEquals(dummyMovie.poster, movieEntites?.poster)


        viewModel.getFilm(dummyMovieTitle)?.observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }

    @Test
    fun getFilmShow() {
        val dummyShow = DataDummy.generateDataShows()[0]
        val dummyShowTitle = dummyShow.title
        val show = MutableLiveData<Film>()
        show.value = dummyShow

        `when`(filmRepository.getFilm(dummyShowTitle)).thenReturn(show)
        val showEntites = viewModel.getFilm(dummyShowTitle)?.value
        verify(filmRepository).getFilm(dummyShowTitle)

        assertNotNull(showEntites)
        assertEquals(dummyShow.title, showEntites?.title)
        assertEquals(dummyShow.status, showEntites?.status)
        assertEquals(dummyShow.originalLanguage, showEntites?.originalLanguage)
        assertEquals(dummyShow.description, showEntites?.description)
        assertEquals(dummyShow.casts, showEntites?.casts)
        assertEquals(dummyShow.poster, showEntites?.poster)


        viewModel.getFilm(dummyShowTitle)?.observeForever(observer)
        verify(observer).onChanged(dummyShow)
    }
}