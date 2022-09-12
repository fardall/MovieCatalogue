package com.example.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.util.LiveDataTestUtil
import com.example.moviecatalogue.util.PagedListUtil
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.utils.DataDummy
import junit.framework.Assert.assertNotNull
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class FilmRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(local, appExecutors)

    private val dummyMovies = DataDummy.generateDataMovies()
    private val dummyShows = DataDummy.generateDataShows()
    private val dummyMovieTitle = dummyMovies[0].title
    private val dummyShowsTitle = dummyShows[0].title
    private val dummyFilmMovie = DataDummy.getSelectedFilm(dummyMovieTitle)
    private val dummyFilmShow = DataDummy.getSelectedFilm(dummyShowsTitle)

    @Test
    fun getMovies() {
        val movies = MutableLiveData<List<Film>>()
        movies.value = dummyMovies
        `when`(local.getAllMovies()).thenReturn(movies)

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getMovies())
        verify(local).getAllMovies()
        assertNotNull(movieEntities)
        assertEquals(dummyMovies.size.toLong(), movieEntities.size.toLong())

    }

    @Test
    fun getShows() {
        val shows = MutableLiveData<List<Film>>()
        shows.value = dummyShows
        `when`(local.getAllShows()).thenReturn(shows)

        val showEntities = LiveDataTestUtil.getValue(filmRepository.getTvShows())
        verify(local).getAllShows()
        assertNotNull(showEntities)
        assertEquals(dummyShows.size.toLong(), showEntities.size.toLong())
    }

    @Test
    fun getFilmMovie() {
        val movie = MutableLiveData<Film>()
        movie.value = dummyMovies[0]
        `when`(local.getFilm(dummyMovieTitle)).thenReturn(movie)

        val movieEntities = LiveDataTestUtil.getSingleValue(filmRepository.getFilm(dummyMovieTitle))

        assertNotNull(movieEntities)
        assertEquals(dummyFilmMovie?.title, movieEntities.title)
        assertEquals(dummyFilmMovie?.status, movieEntities.status)
        assertEquals(dummyFilmMovie?.originalLanguage, movieEntities.originalLanguage)
        assertEquals(dummyFilmMovie?.description, movieEntities.description)
        assertEquals(dummyFilmMovie?.casts, movieEntities.casts)
        assertEquals(dummyFilmMovie?.poster, movieEntities.poster)
    }

    @Test
    fun getFilmShow() {
        val shows = MutableLiveData<Film>()
        shows.value = dummyShows[0]
        `when`(local.getFilm(dummyShowsTitle)).thenReturn(shows)

        val showEntities = LiveDataTestUtil.getSingleValue(filmRepository.getFilm(dummyShowsTitle))

        assertNotNull(showEntities)
        assertEquals(dummyFilmShow?.title, showEntities.title)
        assertEquals(dummyFilmShow?.status, showEntities.status)
        assertEquals(dummyFilmShow?.originalLanguage, showEntities.originalLanguage)
        assertEquals(dummyFilmShow?.description, showEntities.description)
        assertEquals(dummyFilmShow?.casts, showEntities.casts)
        assertEquals(dummyFilmShow?.poster, showEntities.poster)
    }

    @Test
    fun getFavMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        filmRepository.getFavMovies()

        val movieEntities = PagedListUtil.mockPagedList(DataDummy.generateDummyFavMovie())
        verify(local).getFavMovies()
        assertNotNull(movieEntities)
        assertEquals(DataDummy.generateDummyFavMovie().size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getFavShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, Film>
        `when`(local.getFavShows()).thenReturn(dataSourceFactory)
        filmRepository.getFavShows()

        val showEntities = PagedListUtil.mockPagedList(DataDummy.generateDummyFavShow())
        verify(local).getFavShows()
        assertNotNull(showEntities)
        assertEquals(DataDummy.generateDummyFavShow().size.toLong(), showEntities.size.toLong())
    }

}