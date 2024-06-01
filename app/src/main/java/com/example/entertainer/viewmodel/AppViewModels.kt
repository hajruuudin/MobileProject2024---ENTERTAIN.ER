package com.example.entertainer.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.entertainer.data.MovieDao
import com.example.entertainer.data.UserDao
import com.example.entertainer.data.UserMovieDao

/**
 * Factory for creating [HomeScreenViewModel] instances. Same for all other factories
 *
 * @property movieDao The DAO for movies.
 * @property userMovieDao The DAO for user-movie relations.
 * @property userDao The DAO for users.
 */
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

class SignUpViewModelFactory(
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SignUpViewModel::class.java)){
            return SignUpViewModel(userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}

class LogInViewModelFactory(
    private val userDao: UserDao
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LogInViewModel::class.java)){
            return LogInViewModel(userDao) as T
        }

        throw IllegalArgumentException("ERROR")
    }
}



