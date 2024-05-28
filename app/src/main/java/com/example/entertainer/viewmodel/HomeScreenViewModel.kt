package com.example.entertainer.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.User
import com.example.entertainer.data.UserMovie
import com.example.entertainer.data.UserMovieDao
import kotlinx.coroutines.launch


class HomeScreenViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao
) : ViewModel() {
    val movies = mutableStateListOf<Movie>()

    init {
        viewModelScope.launch {
            movies.addAll(movieDao.getAllMovies())
        }
    }

}