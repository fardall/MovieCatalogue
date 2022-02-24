package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.data.source.local.LocalDataSource

class FilmRepository private constructor(private val localDataSource: LocalDataSource) :
    FilmDataSource {

    companion object {
        @Volatile
        private var instance: FilmRepository? = null
        fun getInstance(localDataSource: LocalDataSource): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(localDataSource).apply { instance = this }
            }
    }

    override fun getFilm(title: String): LiveData<Film?> {
        val filmResult = MutableLiveData<Film?>()
        localDataSource.getFilm(title, object : LocalDataSource.LoadFilmCallback {
            override fun onFilmReceived(film: Film) {
                filmResult.postValue(film)
            }
        })
        return filmResult
    }

    override fun getMovies(): LiveData<List<Film>> {
        val moviesResult = MutableLiveData<List<Film>>()
        localDataSource.getMovies(object : LocalDataSource.LoadMoviesCallback {
            override fun onMoviesReceived(movies: List<Film>) {
                moviesResult.postValue(movies)
            }
        })
        return moviesResult
    }

    override fun getTvShows(): LiveData<List<Film>> {
        val showsResult = MutableLiveData<List<Film>>()
        localDataSource.getTvShows(object : LocalDataSource.LoadShowsCallback {
            override fun onShowsReceived(shows: List<Film>) {
                showsResult.postValue(shows)
            }
        })
        return showsResult
    }
}