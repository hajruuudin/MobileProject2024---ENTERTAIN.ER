package com.example.entertainer.viewmodel

import android.icu.text.StringSearch
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao
import kotlinx.coroutines.launch

class MoviesViewModel(
    val movieDao: MovieDao,
    val userDao: UserDao,
    val userMovieDao: UserMovieDao
) : ViewModel() {
    var movies = mutableStateListOf<Movie>()

    fun getAllMovies(){
        viewModelScope.launch {
            movies.clear()
            movies.addAll(movieDao.getAllMovies())
        }
    }

    fun getSearchMovies(search: String){
        viewModelScope.launch {
            movies.clear()
            movies.addAll(movieDao.searchMovies(search))
        }
    }
}