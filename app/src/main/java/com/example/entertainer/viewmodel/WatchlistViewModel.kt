package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao

class WatchlistViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {
}