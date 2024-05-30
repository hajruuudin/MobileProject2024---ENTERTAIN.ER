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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
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
import androidx.compose.ui.tooling.preview.Preview
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
import java.lang.StringBuilder

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemInfoScreen(
    navController: NavController,
    viewModel : ItemInfoViewModel,
    movieId : Int
) {
    var userId = SessionManager.getUserId()
    var thisMovie : Movie = viewModel.getMovie(movieId);


    DisposableEffect(Unit){
        onDispose {
            viewModel.isMovieEntryPresent(userId, thisMovie.id, false, false)
        }
    }

    var watched by remember {
        mutableStateOf(viewModel.getWatchedStatus(userId, thisMovie.id))
    }
    var watchlist by remember {
        mutableStateOf(viewModel.getWatchlistStatus(userId, thisMovie.id))
    }

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

                Text(
                    text = thisMovie.title,
                    style = Typography.headlineMedium,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = thisMovie.genre.value,
                    style = Typography.bodyMedium,
                    color = Light
                )
                Text(
                    text = thisMovie.duration.toString(),
                    style = Typography.bodyMedium,
                    color = Light
                )
                Text(
                    text = thisMovie.director,
                    style = Typography.bodyMedium,
                    color = Light
                )
                Text(
                    text = thisMovie.actors,
                    style = Typography.bodyMedium,
                    color = Light
                )
                Text(
                    text = "Description",
                    style = Typography.bodyMedium,
                    color = Light
                )
                Text(
                    text = "Rating",
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
                            if (viewModel.getWatchedStatus(userId, thisMovie.id) == false) {
                                viewModel.updateWatchedStatus(userId, thisMovie.id, true)
                                watched = !watched
                            } else {
                                viewModel.updateWatchedStatus(userId, thisMovie.id, false)
                                watched = !watched
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
                        onCheckedChange = {if (viewModel.getWatchlistStatus(userId, thisMovie.id) == false) {
                            viewModel.updateWatchlistStatus(userId, thisMovie.id, true)
                            watchlist = !watchlist
                        } else {
                            viewModel.updateWatchlistStatus(userId, thisMovie.id, false)
                            watchlist = !watchlist
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

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ItemInfoPreview()
//{
//    ItemInfoScreen()
//}