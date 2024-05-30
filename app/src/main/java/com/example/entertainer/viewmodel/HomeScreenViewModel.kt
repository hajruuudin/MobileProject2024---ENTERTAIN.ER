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
import kotlinx.coroutines.launch


class HomeScreenViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {
    val movies = mutableStateListOf<Movie>()

    fun updateMovies() {
        // Update movies list when the home screen is entered or re-entered
        viewModelScope.launch {
            movies.clear()
            movies.addAll(movieDao.getAllMovies())
        }
    }

}