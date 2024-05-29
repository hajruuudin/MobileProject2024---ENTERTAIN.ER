package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao

class MoviesViewModel(
    val movieDao: MovieDao,
    val userDao: UserDao,
    val userMovieDao: UserMovieDao
) : ViewModel() {
}