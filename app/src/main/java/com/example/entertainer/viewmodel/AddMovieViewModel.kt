package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao
import kotlinx.coroutines.launch

class AddMovieViewModel(
    val movieDao: MovieDao,
    val userMovieDao: UserMovieDao,
    val userDao: UserDao
) : ViewModel() {


    fun addMovie(movie: Movie){
        viewModelScope.launch {
            movieDao.insert(movie)
        }
    }
}