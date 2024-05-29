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
    var movie : Movie = Movie(999, "Default", MovieCategories.SCIFI, "Should", 2, "Not", "Happen", null);

    fun getMovie(movieId: Int) : Movie{
        viewModelScope.launch {
            movie = movieDao.getMovieById(movieId)
        }

        return movie
    }
}