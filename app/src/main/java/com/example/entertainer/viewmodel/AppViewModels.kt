package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao

class HomeScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HomeScreenViewModel::class.java)){
            return HomeScreenViewModel(movieDao, userMovieDao, userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class MoviesScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MoviesViewModel::class.java)){
            return MoviesViewModel(movieDao, userDao, userMovieDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class WatchlistScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WatchlistViewModel::class.java)){
            return WatchlistViewModel(movieDao, userMovieDao, userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class ProfileScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ProfileViewModel::class.java)){
            return ProfileViewModel(movieDao, userDao, userMovieDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class ItemInfoScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ItemInfoViewModel::class.java)){
            return ItemInfoViewModel(movieDao, userMovieDao, userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class AddMovieScreenModelFactory(
    private val movieDao: MovieDao,
    private val userMovieDao: UserMovieDao,
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(AddMovieViewModel::class.java)){
            return AddMovieViewModel(movieDao, userMovieDao, userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}



