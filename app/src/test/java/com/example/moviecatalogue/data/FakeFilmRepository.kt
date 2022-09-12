package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.utils.AppExecutors

class FakeFilmRepository(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : FilmDataSource {

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

    override fun updateFavorite(title: String, isFavorite: Int) =
        appExecutors.diskIO().execute { localDataSource.updateFavorite(title, isFavorite) }

    override fun deleteFavFilm(film: Film) {
        appExecutors.diskIO().execute { localDataSource.delete(film) }
    }

    override fun insertFilm(film: List<Film>) {
        appExecutors.diskIO().execute { localDataSource.insertFilm(film) }
    }
}