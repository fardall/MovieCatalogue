package com.example.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.moviecatalogue.data.source.local.room.FilmDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class LocalDataSource private constructor(private val filmDao: FilmDao) {
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()



    companion object {

        @Volatile
        private var instance: LocalDataSource? = null

        fun getInstance(filmDao: FilmDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(filmDao).apply { instance = this }
            }
    }

    fun getFavMovies(): DataSource.Factory<Int, Film> = filmDao.getFavMovies()

    fun getFavShows(): DataSource.Factory<Int, Film> = filmDao.getFavTvShows()

    fun delete(film: Film) {
        executorService.execute { filmDao.deleteFilm(film) }
    }

    fun updateFavorite(title: String, isFavorite: Int) {
        executorService.execute { filmDao.updateFavorite(title, isFavorite) }
    }

    fun getAllMovies(): LiveData<List<Film>> {
        return filmDao.getAllMovies()
    }

    fun getAllShows(): LiveData<List<Film>> {
        return filmDao.getAllShows()
    }

    fun getFilm(title: String): LiveData<Film>? = filmDao.getFilm(title)

    fun insertFilm(film: List<Film>) {
        executorService.execute { filmDao.insertFilm(film) }
    }

    fun isEmpty(): Boolean {
         if (filmDao.isEmpty("Aquaman") == null) {
             return true
         }
        return false
    }

}