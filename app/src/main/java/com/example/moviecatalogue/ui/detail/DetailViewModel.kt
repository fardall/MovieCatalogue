package com.example.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.Film

class DetailViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getFilm(title: String) : LiveData<Film?> = filmRepository.getFilm(title)
}