package com.example.moviecatalogue.di

import android.content.Context
import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.data.source.local.room.FilmDatabase
import com.example.moviecatalogue.utils.AppExecutors
import com.example.moviecatalogue.utils.DataDummy

object Injection {
    fun provideRepository(context: Context) : FilmRepository {


        val db = FilmDatabase.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(db.filmDao())
        val appExecutors = AppExecutors()
        if (localDataSource.isEmpty()) {
            localDataSource.insertFilm(DataDummy.generateDataMovies())
            localDataSource.insertFilm(DataDummy.generateDataShows())
        }

        return FilmRepository.getInstance(localDataSource, appExecutors)
    }
}