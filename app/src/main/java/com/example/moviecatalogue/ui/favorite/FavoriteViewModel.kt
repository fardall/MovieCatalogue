package com.example.moviecatalogue.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film

class FavoriteViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<PagedList<Film>> = filmRepository.getFavMovies()

    fun getTvShows(): LiveData<PagedList<Film>> = filmRepository.getFavShows()
}