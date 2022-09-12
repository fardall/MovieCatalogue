package com.example.moviecatalogue.data.source.local

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Film (
    @PrimaryKey
    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "releaseYear")
    var releaseYear: String,

    @ColumnInfo(name = "casts")
    var casts: List<String>,

    @ColumnInfo(name = "status")
    var status: String,

    @ColumnInfo(name = "originalLanguage")
    var originalLanguage: String,

    @ColumnInfo(name = "poster")
    var poster: Int,

    @ColumnInfo(name = "type")
    var type: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Int = 0
) : Parcelable