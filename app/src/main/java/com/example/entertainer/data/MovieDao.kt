package com.example.entertainer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.entertainer.data.Movie
import kotlinx.coroutines.flow.Flow

/* Database Access Object for MOVIES */
@Dao
interface MovieDao {
    @Insert
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Update
    suspend fun update(movie: Movie)

    /* Retrieve all movies from the database */
    @Query("SELECT * FROM Movie")
    suspend fun getAllMovies(): List<Movie>

    /* Retrieve all movies that match the searched string */
    @Query("SELECT * FROM Movie WHERE title LIKE '%' || :search || '%'")
    suspend fun searchMovies(search: String): List<Movie>

    /* Retrieve the movie selected in the UI */
    @Query("SELECT * FROM Movie WHERE id = :id")
    suspend fun getMovieById(id: Int) : Movie
}