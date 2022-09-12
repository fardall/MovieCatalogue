package com.example.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.example.moviecatalogue.data.source.local.Film

@Dao
interface FilmDao {
    @Query("SELECT * FROM film WHERE type = 0 AND isFavorite = 1 ORDER BY title ASC")
    fun getFavMovies(): DataSource.Factory<Int, Film>

    @Query("SELECT * FROM film WHERE type = 1 AND isFavorite = 1 ORDER BY title ASC")
    fun getFavTvShows(): DataSource.Factory<Int, Film>

    @Query("SELECT * FROM film WHERE title = :title")
    fun getFilm(title: String) : LiveData<Film>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFilm(film: List<Film>)

    @Query("SELECT * FROM film WHERE type = 0")
    fun getAllMovies(): LiveData<List<Film>>

    @Query("SELECT * FROM film WHERE type = 1")
    fun getAllShows(): LiveData<List<Film>>

    @Query("UPDATE film SET isFavorite = :isFavorite WHERE title = :title")
    fun updateFavorite(title: String, isFavorite: Int)

    @Query("SELECT * FROM film WHERE title = :title")
    fun isEmpty(title: String): Film

    @Delete
    fun deleteFilm(film: Film)
}