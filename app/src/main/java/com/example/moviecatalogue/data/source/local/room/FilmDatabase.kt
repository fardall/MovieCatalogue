package com.example.moviecatalogue.data.source.local.room

import android.content.Context
import androidx.room.*
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.utils.Converters

@Database(entities = [Film::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

    companion object {

        @Volatile
        private var INSTANCE: FilmDatabase? = null

        fun getInstance(context: Context): FilmDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    FilmDatabase::class.java,
                    "Films.db"
                ).allowMainThreadQueries().build().apply {
                    INSTANCE = this
                }
            }
    }
}