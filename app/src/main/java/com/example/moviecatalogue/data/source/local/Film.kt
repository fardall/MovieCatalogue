package com.example.moviecatalogue.data.source.local

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film (
    var title: String,
    var description: String,
    var releaseYear: String,
    var casts: List<String>,
    var status: String,
    var originalLanguage: String,
    var poster: Int
) : Parcelable