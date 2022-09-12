package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.example.moviecatalogue.data.source.local.Film

interface FilmDataSource {
    fun getFilm(title: String): LiveData<Film>?

    fun getMovies(): LiveData<List<Film>>

    fun getTvShows(): LiveData<List<Film>>

    fun getFavMovies(): LiveData<PagedList<Film>>

    fun getFavShows(): LiveData<PagedList<Film>>

    fun deleteFavFilm(film: Film)

    fun insertFilm(film: List<Film>)

    fun updateFavorite(title: String, isFavorite: Int)
}