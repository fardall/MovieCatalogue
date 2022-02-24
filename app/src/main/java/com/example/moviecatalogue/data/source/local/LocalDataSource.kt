package com.example.moviecatalogue.data.source.local

import android.os.Handler
import android.os.Looper
import com.example.moviecatalogue.utils.DataDummy

class LocalDataSource private constructor(private val data: DataDummy) {
    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(data: DataDummy): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(data).apply { instance = this }
            }
    }

    fun getMovies(callback: LoadMoviesCallback) {
        handler.postDelayed({ callback.onMoviesReceived(data.generateDataMovies()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getTvShows(callback: LoadShowsCallback) {
        handler.postDelayed({ callback.onShowsReceived(data.generateDataShows()) }, SERVICE_LATENCY_IN_MILLIS)
    }

    fun getFilm(title: String, callback: LoadFilmCallback) {
        handler.postDelayed({ data.getSelectedFilm(title)?.let { callback.onFilmReceived(it) } } , SERVICE_LATENCY_IN_MILLIS)
    }
    interface LoadMoviesCallback {
        fun onMoviesReceived(movies: List<Film>)
    }

    interface LoadShowsCallback {
        fun onShowsReceived(shows: List<Film>)
    }

    interface LoadFilmCallback {
        fun onFilmReceived(film: Film)
    }
}