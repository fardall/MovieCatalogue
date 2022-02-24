package com.example.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.di.Injection
import com.example.moviecatalogue.ui.detail.DetailViewModel
import com.example.moviecatalogue.ui.movies.MovieViewModel
import com.example.moviecatalogue.ui.shows.ShowsViewModel

class ViewModelFactory private constructor(private val filmRepository: FilmRepository) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository()).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(ShowsViewModel::class.java) -> {
                ShowsViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(filmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}