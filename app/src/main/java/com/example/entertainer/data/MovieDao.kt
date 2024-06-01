package com.example.entertainer.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.entertainer.data.Movie
import com.example.entertainer.model.MovieCategories
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

    /**
     * Retrieves all movies from the database.
     *
     * @return A list of all movies.
     */
    @Query("SELECT * FROM Movie")
    suspend fun getAllMovies(): List<Movie>

    /**
     * Retrieves all movies from the database that match the user's favorite category.
     *
     * @param genre The favorite category of the user.
     * @return A list of movies that match the given category.
     */
    @Query("SELECT * FROM Movie WHERE genre = :genre")
    suspend fun getCategorizedMovies(genre: MovieCategories): List<Movie>

    /**
     * Retrieves all movies from the database that match the searched string.
     *
     * @param search The search string to match against movie titles.
     * @return A list of movies that match the searched string.
     */
    @Query("SELECT * FROM Movie WHERE title LIKE '%' || :search || '%'")
    suspend fun searchMovies(search: String): List<Movie>

    /**
     * Retrieves a movie from the database by its ID.
     *
     * @param id The ID of the movie to be retrieved.
     * @return The movie with the specified ID.
     */
    @Query("SELECT * FROM Movie WHERE id = :id")
    suspend fun getMovieById(id: Int) : Movie

    /**
     * Retrieves all movies from the database that the user has in their watchlist.
     *
     * @param userId The ID of the user.
     * @return A list of movies in the user's watchlist.
     */
    @Query("SELECT m.*\n" +
            "FROM Movie m\n" +
            "JOIN UserMovie um ON m.id = um.movieId\n" +
            "WHERE um.watchlist = TRUE AND um.userId = :userId;\n")
    suspend fun getWatchlist(userId: Int) : List<Movie>

    /**
     * Retrieves all movies from the database that the user has labeled as "watched".
     *
     * @param userId The ID of the user.
     * @return A list of movies labeled as "watched" by the user.
     */
    @Query("SELECT m.*\n" +
            "FROM Movie m\n" +
            "JOIN UserMovie um ON m.id = um.movieId\n" +
            "WHERE um.watched = TRUE AND um.userId = :userId;\n")
    suspend fun getWatched(userId: Int) : List<Movie>
}