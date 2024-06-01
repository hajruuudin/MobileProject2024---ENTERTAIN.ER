package com.example.entertainer.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.data.Movie
import com.example.entertainer.data.SessionManager
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.components.convertToImageBitmap
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.ItemInfoViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemInfoScreen(
    navController: NavController,
    viewModel : ItemInfoViewModel,
    movieId : Int
) {
    /* Initialize the UserID and the movie that is retrieved */
    val userId = SessionManager.getUserId()
    val thisMovie : Movie = viewModel.getMovie(movieId)

    /* Initialize watched and watchlist variables with values from the ViewModel */
    val initialWatched = remember { mutableStateOf(viewModel.getWatchedStatus(userId, thisMovie.id)) }
    val initialWatchlist = remember { mutableStateOf(viewModel.getWatchlistStatus(userId, thisMovie.id)) }

    /* When the movie is changed, update the Item Info Screen */
    LaunchedEffect(thisMovie) {
        viewModel.isMovieEntryPresent(userId, thisMovie.id, false, false)
        initialWatched.value = viewModel.getWatchedStatus(userId, thisMovie.id)
        initialWatchlist.value = viewModel.getWatchlistStatus(userId, thisMovie.id)
    }

    /* When navigating from the screen, set the variables to false */
    DisposableEffect(Unit){
        onDispose {
            initialWatched.value = false
            initialWatchlist.value = false
        }
    }

    /* Used as UI states for the checkboxes */
    var watched by initialWatched
    var watchlist by initialWatchlist

    Scaffold(
        topBar = {
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            ){
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = Light,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Spacer(modifier = Modifier.width(20.dp))

                Text(text = "Movie Info", style = Typography.labelMedium, color = Light)
            }
        },
        bottomBar = {
            Navbar(
                onHomeClick = {navController.navigate(Screen.HomeScreen.route)},
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
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ){

                Spacer(modifier = Modifier.height(30.dp))

                if(thisMovie.image != null){
                    Image(
                        bitmap = convertToImageBitmap(thisMovie.image!!),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(50.dp))
                            .size(400.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.defaultcover),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(RoundedCornerShape(20.dp))
                            .size(300.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Title", style = Typography.labelLarge)
                Text(
                    text = thisMovie.title,
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Genre", style = Typography.labelLarge)
                Text(
                    text = thisMovie.genre.value,
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Duration", style = Typography.labelLarge)
                Text(
                    text = thisMovie.duration.toString(),
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Director", style = Typography.labelLarge)
                Text(
                    text = thisMovie.director,
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Actors", style = Typography.labelLarge)
                Text(
                    text = thisMovie.actors,
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Description", style = Typography.labelLarge)
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. ",
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Rating", style = Typography.labelLarge)
                Text(
                    text = thisMovie.rating,
                    style = Typography.bodyMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Mark as Watched",
                        style = Typography.labelMedium,
                        color = Light
                    )

                    Checkbox(
                        checked = watched,
                        onCheckedChange = {
                            val newWatchedStatus = !watched

                            if (viewModel.getWatchedStatus(userId, thisMovie.id) != newWatchedStatus) {
                                viewModel.updateWatchedStatus(userId, thisMovie.id, newWatchedStatus)
                                watched = newWatchedStatus
                            }},
                        colors = CheckboxDefaults.colors(
                            checkedColor = Buttons
                        )
                    )
                }

                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "Add to Watchlist",
                        style = Typography.labelMedium,
                        color = Light
                    )

                    Checkbox(
                        checked = watchlist,
                        onCheckedChange = {
                            val newWatchlistStatus = !watchlist

                            if (viewModel.getWatchlistStatus(userId, thisMovie.id) != newWatchlistStatus) {
                                viewModel.updateWatchlistStatus(userId, thisMovie.id, newWatchlistStatus)
                                watchlist = newWatchlistStatus
                            }},
                        colors = CheckboxDefaults.colors(
                            checkedColor = Buttons
                        )
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }
}
