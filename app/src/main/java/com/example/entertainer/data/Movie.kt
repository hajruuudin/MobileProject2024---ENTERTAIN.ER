package com.example.entertainer.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.entertainer.model.MovieCategories

/* Entity for MOVIES: The primary key is the Movie ID */
@Entity(tableName = "Movie")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val genre: MovieCategories,
    val director: String,
    val duration: Int,
    val actors: String,
    val rating: String
)
