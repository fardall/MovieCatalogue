package com.example.moviecatalogue.ui.shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film

class ShowsViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShows() : LiveData<List<Film>> = filmRepository.getTvShows()
}