package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao
import com.example.entertainer.model.MovieCategories
import kotlinx.coroutines.launch

class ItemInfoViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {
    var movie : Movie = Movie(999, "Default", MovieCategories.SCIFI, "Should", 2.0, "Not", "Happen", null);
    var watched = false;
    var watchlist = false;

    fun getMovie(movieId: Int) : Movie{
        viewModelScope.launch {
            movie = movieDao.getMovieById(movieId)
        }

        return movie
    }

    fun isMovieEntryPresent(userId: Int, movieId: Int, watched: Boolean, watchlist: Boolean){
        viewModelScope.launch {
            if(userMovieDao.isMoviePresent(userId, movieId).isEmpty()){
                addMovieEntry(userId, movieId, watched, watchlist)
            }
        }
    }

    private fun addMovieEntry(userId: Int, movieId: Int, watched: Boolean, watchlist: Boolean){
        viewModelScope.launch {
            userMovieDao.insertEntry(userId, movieId, watched, watchlist)
        }
    }

    fun getWatchedStatus(userId: Int, movieId: Int) : Boolean{
        viewModelScope.launch {
            watched = userMovieDao.getWatchedStatus(userId, movieId)
        }
        return watched
    }

    fun getWatchlistStatus(userId: Int, movieId: Int) : Boolean{
        viewModelScope.launch {
            watchlist = userMovieDao.getWatchlistStatus(userId, movieId)
        }
        return watchlist
    }

    fun updateWatchedStatus(userId: Int, movieId: Int, watchedUpdate: Boolean){
        viewModelScope.launch{
            userMovieDao.updateWatchedStatus(userId, movieId, watchedUpdate)
        }
    }

    fun updateWatchlistStatus(userId: Int, movieId: Int, watchlistUpdate: Boolean){
        viewModelScope.launch{
            userMovieDao.updateWatchlistStatus(userId, movieId, watchlistUpdate)
        }
    }
}