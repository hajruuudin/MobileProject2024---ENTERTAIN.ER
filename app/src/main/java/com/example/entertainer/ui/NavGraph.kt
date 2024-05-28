package com.example.entertainer.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.entertainer.ui.screen.HomeScreen
import com.example.entertainer.ui.screen.ItemInfoScreen
import com.example.entertainer.ui.screen.LogInScreen
import com.example.entertainer.ui.screen.SignUpScreen
import com.example.entertainer.viewmodel.HomeScreenViewModel

sealed class Screen(val route: String){
    object HomeScreen: Screen("home")
    object MoviesScreen: Screen("movies")
    object WatchlistScreen: Screen("watchlist")
    object ProfileScreen: Screen("profile")
    object AddMoviesScreen: Screen("addmovie")
    object LogInScreen: Screen("login")
    object SignUpScreen: Screen("signup")
    object ItemInfoScreen: Screen("iteminfo")
}

@Composable
fun NavGraph (
    navController: NavHostController,
    viewModel: HomeScreenViewModel
){
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ){
        composable(route = Screen.LogInScreen.route){
            LogInScreen(navController)
        }
        composable(route = Screen.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(route = Screen.HomeScreen.route){
            HomeScreen(navController, viewModel)
        }
//        composable(route = Screen.WatchlistScreen.route){
//            WatchlistScreen()
//        }
//        composable(route = Screen.MoviesScreen.route){
//            MoviesScreen()
//        }
//        composable(route = Screen.ProfileScreen.route){
//            ProfileScreen()
//        }
//        composable(route = Screen.AddMoviesScreen.route){
//            AddMoviesScreen()
//        }
        composable(route = Screen.ItemInfoScreen.route){
            ItemInfoScreen()
        }
    }
}