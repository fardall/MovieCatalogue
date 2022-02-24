package com.example.moviecatalogue.data

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.data.source.local.Film

interface FilmDataSource {
    fun getFilm(title: String): LiveData<Film?>

    fun getMovies(): LiveData<List<Film>>

    fun getTvShows(): LiveData<List<Film>>
}