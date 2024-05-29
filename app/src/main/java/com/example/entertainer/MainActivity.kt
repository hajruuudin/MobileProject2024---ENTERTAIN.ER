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
import com.example.entertainer.viewmodel.MoviesScreenModelFactory
import com.example.entertainer.viewmodel.MoviesViewModel
import com.example.entertainer.viewmodel.ProfileScreenModelFactory
import com.example.entertainer.viewmodel.ProfileViewModel
import com.example.entertainer.viewmodel.WatchlistScreenModelFactory
import com.example.entertainer.viewmodel.WatchlistViewModel

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieDao = DatabaseProvider.getDatabase(this).movieDao()
        val userMovieDao = DatabaseProvider.getDatabase(this).userMovieDao()
        val userDao = DatabaseProvider.getDatabase(this).userDao()

        val homeViewModel = ViewModelProvider(this, HomeScreenModelFactory(movieDao, userMovieDao, userDao)).get(HomeScreenViewModel::class.java)
        val moviesViewModel = ViewModelProvider(this, MoviesScreenModelFactory(movieDao, userMovieDao, userDao)).get(MoviesViewModel::class.java)
        val watchlistViewModel = ViewModelProvider(this, WatchlistScreenModelFactory(movieDao, userMovieDao, userDao)).get(WatchlistViewModel::class.java)
        val profileViewModel = ViewModelProvider(this, ProfileScreenModelFactory(movieDao, userMovieDao, userDao)).get(ProfileViewModel::class.java)
        val itemInfoViewModel = ViewModelProvider(this, ItemInfoScreenModelFactory(movieDao, userMovieDao, userDao)).get(ItemInfoViewModel::class.java)
        val addMovieViewModel = ViewModelProvider(this, AddMovieScreenModelFactory(movieDao, userMovieDao, userDao)).get(AddMovieViewModel::class.java)

        setContent {
            EntertainerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        homeViewModel = homeViewModel,
                        moviesViewModel = moviesViewModel,
                        watchlistViewModel = watchlistViewModel,
                        profileViewModel = profileViewModel,
                        itemInfoViewModel = itemInfoViewModel,
                        addMovieViewModel = addMovieViewModel
                    )
                }
            }
        }
    }
}
