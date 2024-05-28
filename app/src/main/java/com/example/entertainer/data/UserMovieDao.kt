package com.example.entertainer.data

import androidx.room.Dao
import androidx.room.Query
import com.example.entertainer.data.Movie
import kotlinx.coroutines.flow.Flow

/* Database Access Object for USER MOVIES */
@Dao
interface UserMovieDao {
    /* Retrieve all movies from the database that are in the users watchlist */
    @Query("SELECT Movie.* FROM Movie " +
            "INNER JOIN UserMovie ON Movie.id = UserMovie.movieId " +
            "WHERE UserMovie.userId = :id " +
            "AND UserMovie.watchlist = 1")
    fun getWatchlist(id: Int) : Flow<List<Movie>>

    /* Retrieve all movies from the database that are watched by the user */
    @Query("SELECT Movie.* FROM Movie " +
            "INNER JOIN UserMovie ON Movie.id = UserMovie.movieId " +
            "WHERE UserMovie.userId = :id " +
            "AND UserMovie.watched = 1")
    fun getWatchedMovies(id: Int) : Flow<List<Movie>>

    /* Add a movie to the watchlist of the user */
    @Query("UPDATE UserMovie SET watchlist = :watchlist WHERE userId = :userId AND movieId = :movieId")
    suspend fun updateWatchlistStatus(userId: Int, movieId: Int, watchlist: Boolean)

    /* Mark a movie as watched for the user */
    @Query("UPDATE UserMovie SET watched = :watched WHERE userId = :userId AND movieId = :movieId")
    suspend fun updateWatchedStatus(userId: Int, movieId: Int, watched: Boolean)
}