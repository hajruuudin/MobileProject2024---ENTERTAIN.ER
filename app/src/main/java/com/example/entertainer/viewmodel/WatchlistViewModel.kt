package com.example.entertainer.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovie
import com.example.entertainer.data.UserMovieDao
import kotlinx.coroutines.launch

class WatchlistViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {
    var watchlist = mutableStateListOf<Movie>()

    fun updateWatchlist(userId : Int) {
        // Update movies list when the home screen is entered or re-entered
        viewModelScope.launch {
            watchlist.clear()
            watchlist.addAll(movieDao.getWatchlist(userId))
        }
    }
}