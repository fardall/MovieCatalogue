package com.example.moviecatalogue.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film

class MovieViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<List<Film>> = filmRepository.getMovies()

}