package com.example.entertainer.data

import androidx.room.Dao
import androidx.room.Query
import com.example.entertainer.data.Movie
import kotlinx.coroutines.flow.Flow

/* Database Access Object for USER MOVIES */
@Dao
interface UserMovieDao {
    /**
     * Inserts an entry for the specified movie into the database for the user.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @param watched The watched status of the movie.
     * @param watchlist The watchlist status of the movie.
     */
    @Query("INSERT INTO UserMovie (userId, movieId, watched, watchlist) VALUES (:userId, :movieId, :watched, :watchlist)" )
    suspend fun insertEntry(userId: Int, movieId: Int, watched: Boolean, watchlist: Boolean)

    /**
     * Checks if the user has already viewed the movie and has an entry for that movie.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @return A list of UserMovie entries matching the userId and movieId.
     */
    @Query("SELECT * FROM UserMovie WHERE userId = :userId AND movieId = :movieId")
    suspend fun isMoviePresent(userId: Int, movieId: Int) : List<UserMovie>

    /**
     * Retrieves the watched status for the specified movie and user.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @return The watched status of the movie for the user.
     */
    @Query("SELECT  watched FROM UserMovie WHERE userId = :userId AND movieId = :movieId")
    suspend fun getWatchedStatus(userId: Int, movieId: Int) : Boolean

    /**
     * Retrieves the watchlist status for the specified movie and user.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @return The watchlist status of the movie for the user.
     */
    @Query("SELECT  watchlist FROM UserMovie WHERE userId = :userId AND movieId = :movieId")
    suspend fun getWatchlistStatus(userId: Int, movieId: Int) : Boolean

    /**
     * Adds a movie to the watchlist of the user.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @param watchlist The new watchlist status of the movie.
     */
    @Query("UPDATE UserMovie SET watchlist = :watchlist WHERE userId = :userId AND movieId = :movieId")
    suspend fun updateWatchlistStatus(userId: Int, movieId: Int, watchlist: Boolean)

    /**
     * Marks a movie as watched for the user.
     *
     * @param userId The ID of the user.
     * @param movieId The ID of the movie.
     * @param watched The new watched status of the movie.
     */
    @Query("UPDATE UserMovie SET watched = :watched WHERE userId = :userId AND movieId = :movieId")
    suspend fun updateWatchedStatus(userId: Int, movieId: Int, watched: Boolean)
}