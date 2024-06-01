package com.example.entertainer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.entertainer.data.DatabaseProvider
import com.example.entertainer.ui.NavGraph
import com.example.entertainer.ui.theme.EntertainerTheme
import com.example.entertainer.viewmodel.AddMovieScreenModelFactory
import com.example.entertainer.viewmodel.AddMovieViewModel
import com.example.entertainer.viewmodel.HomeScreenModelFactory
import com.example.entertainer.viewmodel.HomeScreenViewModel
import com.example.entertainer.viewmodel.ItemInfoScreenModelFactory
import com.example.entertainer.viewmodel.ItemInfoViewModel
import com.example.entertainer.viewmodel.LogInViewModel
import com.example.entertainer.viewmodel.LogInViewModelFactory
import com.example.entertainer.viewmodel.MoviesScreenModelFactory
import com.example.entertainer.viewmodel.MoviesViewModel
import com.example.entertainer.viewmodel.ProfileScreenModelFactory
import com.example.entertainer.viewmodel.ProfileViewModel
import com.example.entertainer.viewmodel.SignUpViewModel
import com.example.entertainer.viewmodel.SignUpViewModelFactory
import com.example.entertainer.viewmodel.WatchlistScreenModelFactory
import com.example.entertainer.viewmodel.WatchlistViewModel

/**
 * The main activity of the Entertainer application.
 *
 * This activity is responsible for setting up the content view and initializing the view models
 * for various screens in the application. The navigation graph had the LogIn screen currently set as
 * the home screen, or the first screen within the application itself.
 *
 * Please note: Log-In is not implemented, however addition of users is available within the sign up page
 */
class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Instantiating the DAOs required for making the view models */
        val movieDao = DatabaseProvider.getDatabase(this).movieDao()
        val userMovieDao = DatabaseProvider.getDatabase(this).userMovieDao()
        val userDao = DatabaseProvider.getDatabase(this).userDao()

        /* Generate the view models for all the screens */
        val homeViewModel = ViewModelProvider(this, HomeScreenModelFactory(movieDao, userMovieDao, userDao)).get(HomeScreenViewModel::class.java)
        val moviesViewModel = ViewModelProvider(this, MoviesScreenModelFactory(movieDao, userMovieDao, userDao)).get(MoviesViewModel::class.java)
        val watchlistViewModel = ViewModelProvider(this, WatchlistScreenModelFactory(movieDao, userMovieDao, userDao)).get(WatchlistViewModel::class.java)
        val profileViewModel = ViewModelProvider(this, ProfileScreenModelFactory(movieDao, userMovieDao, userDao)).get(ProfileViewModel::class.java)
        val itemInfoViewModel = ViewModelProvider(this, ItemInfoScreenModelFactory(movieDao, userMovieDao, userDao)).get(ItemInfoViewModel::class.java)
        val addMovieViewModel = ViewModelProvider(this, AddMovieScreenModelFactory(movieDao, userMovieDao, userDao)).get(AddMovieViewModel::class.java)
        val signUpViewModel = ViewModelProvider(this, SignUpViewModelFactory(userDao)).get(SignUpViewModel::class.java)
        val loginUpViewModel = ViewModelProvider(this, LogInViewModelFactory(userDao)).get(LogInViewModel::class.java)

        setContent {
            EntertainerTheme {
                /* A surface container using the 'background' color from the theme */
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    /* Entry point for the application: start location is Log-In */
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        homeViewModel = homeViewModel,
                        moviesViewModel = moviesViewModel,
                        watchlistViewModel = watchlistViewModel,
                        profileViewModel = profileViewModel,
                        itemInfoViewModel = itemInfoViewModel,
                        addMovieViewModel = addMovieViewModel,
                        signUpViewModel = signUpViewModel,
                        logInViewModel = loginUpViewModel
                    )
                }
            }
        }
    }
}
