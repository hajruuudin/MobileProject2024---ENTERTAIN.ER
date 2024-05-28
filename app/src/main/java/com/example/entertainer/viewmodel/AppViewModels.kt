package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserMovieDao

//object AppViewModels {
//    val Factory = viewModelFactory {
//        initializer {
//            HomeScreenViewModel()
//        }
//    }
//}

class HomeScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeScreenViewModel::class.java)){
            return HomeScreenViewModel(movieDao, userMovieDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}