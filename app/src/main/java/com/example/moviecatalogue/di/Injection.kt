package com.example.moviecatalogue.di

import com.example.moviecatalogue.data.FilmRepository
import com.example.moviecatalogue.data.source.local.LocalDataSource
import com.example.moviecatalogue.utils.DataDummy

object Injection {
    fun provideRepository() : FilmRepository {

        val remoteDataSource = LocalDataSource.getInstance(DataDummy)

        return FilmRepository.getInstance(remoteDataSource)
    }
}