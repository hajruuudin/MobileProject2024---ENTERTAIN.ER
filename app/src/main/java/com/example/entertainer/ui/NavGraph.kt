package com.example.entertainer.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.entertainer.ui.screen.AddMovieScreen
import com.example.entertainer.ui.screen.HomeScreen
import com.example.entertainer.ui.screen.ItemInfoScreen
import com.example.entertainer.ui.screen.LogInScreen
import com.example.entertainer.ui.screen.MoviesScreen
import com.example.entertainer.ui.screen.ProfileScreen
import com.example.entertainer.ui.screen.SignUpScreen
import com.example.entertainer.ui.screen.WatchlistScreen
import com.example.entertainer.viewmodel.AddMovieViewModel
import com.example.entertainer.viewmodel.HomeScreenViewModel
import com.example.entertainer.viewmodel.ItemInfoViewModel
import com.example.entertainer.viewmodel.LogInViewModel
import com.example.entertainer.viewmodel.MoviesViewModel
import com.example.entertainer.viewmodel.ProfileViewModel
import com.example.entertainer.viewmodel.SignUpViewModel
import com.example.entertainer.viewmodel.WatchlistViewModel

/**
 * Represents various screens in the application and their corresponding routes.
 */
sealed class Screen(val route: String){
    /* Log in and Sign Up Routes */
    object LogInScreen: Screen("login")
    object SignUpScreen: Screen("signup")

    /* Navbar Routes */
    object HomeScreen: Screen("home")
    object MoviesScreen: Screen("movies")
    object WatchlistScreen: Screen("watchlist")
    object ProfileScreen: Screen("profile")

    /* Item info and Admin add Movies Screen */
    object AddMoviesScreen: Screen("addmovie")
    object ItemInfoScreen: Screen("iteminfo")
}

/**
 * Navigation graph of the application.
 *
 * @param navController The navigation controller.
 * @param homeViewModel The view model for the home screen.
 * @param moviesViewModel The view model for the movies screen.
 * @param watchlistViewModel The view model for the watchlist screen.
 * @param profileViewModel The view model for the profile screen.
 * @param itemInfoViewModel The view model for the item info screen.
 * @param addMovieViewModel The view model for the add movie screen.
 * @param signUpViewModel The view model for the sign-up screen.
 * @param logInViewModel The view model for the log-in screen.
 */
@Composable
fun NavGraph (
    navController: NavHostController,
    homeViewModel: HomeScreenViewModel,
    moviesViewModel: MoviesViewModel,
    watchlistViewModel: WatchlistViewModel,
    profileViewModel: ProfileViewModel,
    itemInfoViewModel: ItemInfoViewModel,
    addMovieViewModel: AddMovieViewModel,
    signUpViewModel: SignUpViewModel,
    logInViewModel: LogInViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.LogInScreen.route
    ){
        /* Log in and Sign Up Routes */
        composable(route = Screen.LogInScreen.route){
            LogInScreen(navController, logInViewModel)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController, signUpViewModel)
        }

        /* Navbar Routes */
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController, homeViewModel)
        }
        composable(route = Screen.MoviesScreen.route){
            MoviesScreen(navController, moviesViewModel)
        }
        composable(route = Screen.WatchlistScreen.route){
            WatchlistScreen(navController, watchlistViewModel)
        }
        composable(route = Screen.ProfileScreen.route){
            ProfileScreen(navController, profileViewModel)
        }

        /* Item info and Admin add Movies Screen */
        composable(route = Screen.AddMoviesScreen.route){
            AddMovieScreen(navController, addMovieViewModel)
        }
        composable(
            route = Screen.ItemInfoScreen.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ){
            val movieId = it.arguments?.getInt("movieId")
            ItemInfoScreen(navController, itemInfoViewModel, movieId!!)
        }
    }
}