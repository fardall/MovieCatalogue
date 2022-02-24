package com.example.moviecatalogue.data

import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.utils.DataDummy
import junit.framework.Assert.assertNotNull
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
//
//class FilmRepositoryTest {
//    private val local = Mockito.mock(LocalDataSource::class.java)
//    private val filmRepository = FakeFilmRepository(local)
//
//    private val dummyMovies = DataDummy.generateDataMovies()
//    private val dummyShows = DataDummy.generateDataShows()
//    private val dummyMovieTitle = dummyMovies[0].title
//    private val dummyShowsTitle = dummyShows[0].title
//    private val dummyFilmMovie = DataDummy.getSelectedFilm(dummyMovieTitle)
//    private val dummyFilmShow = DataDummy.getSelectedFilm(dummyShowsTitle)
//
//    @Test
//    fun getMovies() {
//        `when`<List<Film>>(local.getMovies()).thenReturn(dummyMovies)
//        val movies = filmRepository.getMovies()
//        verify(local).getMovies()
//        assertNotNull(movies)
//        assertEquals(dummyMovies.size.toLong(), movies.size.toLong())
//    }
//
//}