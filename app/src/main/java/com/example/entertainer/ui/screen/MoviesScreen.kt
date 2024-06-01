package com.example.entertainer.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entertainer.data.SessionManager
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.GenericSmallTextField
import com.example.entertainer.ui.components.MovieCardMedium
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.MoviesViewModel
import com.example.entertainer.viewmodel.WatchlistViewModel

/* Movies Screen */
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoviesScreen(
    navController: NavController,
    viewModel: MoviesViewModel
){
    val userId = SessionManager.getUserId()
    LaunchedEffect(Unit){
        viewModel.getAllMovies()
    }

    var search by remember { mutableStateOf("") }
    /* USE THIS TO DETERMINE IF THE USER IS AN ADMIN */
    var showButton = if (userId == 1) true else false;

    Scaffold(
        floatingActionButton = {
            if (showButton) {
                FloatingActionButton(
                    onClick = { navController.navigate(Screen.AddMoviesScreen.route)},
                    containerColor = Buttons,
                    contentColor = Light
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = null
                    )
                }
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {
            Navbar(
                onHomeClick = {navController.navigate(Screen.HomeScreen.route)},
                onMoviesClick = {},
                onWatchlistClick = {navController.navigate(Screen.WatchlistScreen.route)},
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
                    text = "Browse Movies",
                    style = Typography.headlineLarge,
                    color = Light,
                    fontSize = 50.sp,
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row (
                    modifier = Modifier.width(350.dp)
                ){
                    GenericSmallTextField(
                        value = search,
                        onValueChange = {search = it},
                        label = "Name...",
                        keyboardOptions = KeyboardOptions.Default
                    )

                    Button(
                        onClick = {viewModel.getSearchMovies(search)},
                        modifier = Modifier.size(height = 55.dp, width = 180.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Buttons,
                            contentColor = Light
                        ),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Text(
                            text = "Search",
                            style = Typography.labelMedium
                        )
                    }
                }

                Spacer(modifier = Modifier.height(30.dp))

                if(viewModel.movies.isEmpty()){
                    Text(
                        text = "No movies!",
                        style = Typography.headlineLarge,
                        color = Light
                    )
                    Text(
                        text = "We can't find anything",
                        style = Typography.labelMedium,
                        color = Color.LightGray
                    )
                } else {
                    LazyColumn(){
                        items(viewModel.movies){movie ->
                            MovieCardMedium(
                                movie = movie,
                                onCardClick = {
                                    navController.navigate(Screen.ItemInfoScreen.route + "/" + movie.id)
                                },
                            )

                            Spacer(modifier = Modifier.height(15.dp))
                        }
                    }
                }

            }
        }
    }
}
