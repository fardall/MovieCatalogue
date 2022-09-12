package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.utils.DataDummy

class FilmRepository private constructor(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FilmDataSource {
    val movies = DataDummy.generateDataMovies()
    val shows = DataDummy.generateDataShows()

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(localDataSource: LocalDataSource, appExecutors: AppExecutors): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(localDataSource, appExecutors).apply { instance = this }
            }
    }

    override fun updateFavorite(title: String, isFavorite: Int) {
        localDataSource.updateFavorite(title, isFavorite)
    }

    override fun getFilm(title: String): LiveData<Film>? = localDataSource.getFilm(title)

    override fun getMovies(): LiveData<List<Film>> = localDataSource.getAllMovies()

    override fun getTvShows(): LiveData<List<Film>> = localDataSource.getAllShows()

    override fun getFavMovies(): LiveData<PagedList<Film>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun getFavShows(): LiveData<PagedList<Film>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavShows(), config).build()
    }

    override fun insertFilm(film: List<Film>) {
        appExecutors.diskIO().execute { localDataSource.insertFilm(film) }
    }

    override fun deleteFavFilm(film: Film) {
        appExecutors.diskIO().execute { localDataSource.delete(film) }
    }



}