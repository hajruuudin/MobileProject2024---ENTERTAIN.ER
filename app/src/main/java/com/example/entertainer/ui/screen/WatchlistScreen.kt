package com.example.entertainer.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.entertainer.data.SessionManager
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.MovieCardMedium
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.WatchlistViewModel

/* Watchlist Screen */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WatchlistScreen(
    navController: NavController,
    viewModel: WatchlistViewModel
){
    var userId = SessionManager.getUserId()

    LaunchedEffect(Unit){
        viewModel.updateWatchlist(userId)
    }
    DisposableEffect(Unit){
        onDispose {
            viewModel.updateWatchlist(userId)
        }
    }

    Scaffold(
        bottomBar = {
            Navbar(
                onHomeClick = {navController.navigate(Screen.HomeScreen.route)},
                onMoviesClick = {navController.navigate(Screen.MoviesScreen.route)},
                onWatchlistClick = {},
                onProfileClick = {navController.navigate(Screen.ProfileScreen.route)}
            )
        }
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(UIBackground)
                .padding(paddingValues = it)
        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = "Watchlist",
                    style = Typography.headlineLarge,
                    color = Light,
                    fontSize = 50.sp,
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Keep track of your movie ideas:",
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(30.dp))

                if(viewModel.watchlist.isEmpty()){
                    Text(
                        text = "No movies!",
                        style = Typography.headlineLarge,
                        color = Light
                    )
                    Text(
                        text = "Your watchlist is empty",
                        style = Typography.labelMedium,
                        color = Color.LightGray
                    )
                } else {
                    LazyColumn(){
                        items(viewModel.watchlist){movie ->
                            MovieCardMedium(
                                movie = movie,
                                onCardClick = {
                                    navController.navigate(Screen.ItemInfoScreen.route + "/" + movie.id)
                                }
                            )
                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }

            }
        }
    }
}
