package com.example.entertainer.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.User
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovie
import com.example.entertainer.data.UserMovieDao
import com.example.entertainer.model.MovieCategories
import kotlinx.coroutines.launch


class HomeScreenViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {
    var movies = mutableStateListOf<Movie>()
    var watchlist = mutableStateListOf<Movie>()
    var loggedUser = User(999,"", "", "", "", "12345", MovieCategories.ROMANCE, false)

    fun getLoggedUser(userId : Int){
        viewModelScope.launch {
            loggedUser = userDao.getUser(userId)
            updateMovies()
            updateWatchlist()
        }
    }

    fun updateMovies() {
        // Update movies list when the home screen is entered or re-entered
        viewModelScope.launch {
            movies.clear()
            movies.addAll(movieDao.getCategorizedMovies(loggedUser.favourite))
        }
    }

    fun updateWatchlist() {
        // Update movies list when the home screen is entered or re-entered
        viewModelScope.launch {
            watchlist.clear()
            watchlist.addAll(movieDao.getWatchlist(loggedUser.id))
        }
    }

}