package com.example.entertainer.ui.screen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.entertainer.data.DatabaseProvider
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.MovieCardLarge
import com.example.entertainer.ui.components.MovieCardSmall
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.HomeScreenViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeScreenViewModel = viewModel()
){
    DisposableEffect(Unit){
        onDispose {
            viewModel.updateMovies()
        }
    }

    Scaffold(
        bottomBar = {
            Navbar(
            onHomeClick = {},
            onMoviesClick = {navController.navigate(Screen.MoviesScreen.route)},
            onWatchlistClick = {navController.navigate(Screen.WatchlistScreen.route)},
            onProfileClick = {navController.navigate(Screen.ProfileScreen.route)}
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(UIBackground)
                .padding(paddingValues = it)
        ){

            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(80.dp))
                Text(
                    text = "Homepage",
                    style = Typography.headlineLarge,
                    fontSize = 50.sp,
                    color = Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth()
                )

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Todays movie recommendation:",
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                MovieCardLarge(
                    onCardClick = { /*TODO*/ },
                    title = "Fast & Furious",
                    genre = MovieCategories.ACTION,
                    duration = 2,
                    director = "James Wan",
                    rating = "4 stars"
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Your watchlist:",
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(){
                    items(viewModel.movies) {movie ->
                        MovieCardSmall(
                            movie = movie,
                            onCardClick = {
                                navController.navigate(Screen.ItemInfoScreen.route + "/" + movie.id)
                            }
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Based on your favourite category:",
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(){
                    items(viewModel.movies) {movie ->
                        MovieCardSmall(
                            movie = movie,
                            onCardClick = {
                                navController.navigate(Screen.ItemInfoScreen.route + "/" + movie.id)
                            }
                        )

                        Spacer(modifier = Modifier.width(15.dp))
                    }
                }

                Spacer(modifier = Modifier.height(150.dp))

            }

        }
    }
}
//
//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview(){
//    HomeScreen();
//}