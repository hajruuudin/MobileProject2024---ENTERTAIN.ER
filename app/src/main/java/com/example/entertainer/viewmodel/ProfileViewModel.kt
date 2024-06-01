package com.example.entertainer.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.entertainer.data.Movie
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.User
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao
import com.example.entertainer.model.MovieCategories
import kotlinx.coroutines.launch

class ProfileViewModel(
    val movieDao: MovieDao,
    val userDao: UserDao,
    val userMovieDao: UserMovieDao
) : ViewModel() {
    var userWatched = mutableStateListOf<Movie>()
    var userID : Int = 1;
    var user = User(999,"", "", "", "", "12345", MovieCategories.ACTION, false)

    fun updateUserWatchedList() {
        viewModelScope.launch {
            userWatched.clear()
            userWatched.addAll(movieDao.getWatched(userID))
        }
    }

    fun getUserData(){
        viewModelScope.launch{
            user = userDao.getUser(userID)
        }
    }
}