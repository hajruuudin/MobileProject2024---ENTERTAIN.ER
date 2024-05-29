package com.example.entertainer.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.ImmutableTextField
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel
) {
    Scaffold(
        bottomBar = {
            Navbar(
                onHomeClick = {navController.navigate(Screen.HomeScreen.route)},
                onMoviesClick = {navController.navigate(Screen.MoviesScreen.route)},
                onWatchlistClick = {navController.navigate(Screen.WatchlistScreen.route)},
                onProfileClick = {}
            )
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(UIBackground)
                .padding(paddingValues = it)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.verticalScroll(rememberScrollState())
            ) {

                Spacer(modifier = Modifier.height(60.dp))

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier.size(100.dp),
                    colorFilter = ColorFilter.tint(Light)
                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    text = "My Profile",
                    style = Typography.headlineLarge,
                    color = Light
                )

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    horizontalAlignment = Alignment.Start
                ){
                    Text(text = "Name", style = Typography.labelMedium, color = Light, modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                    ImmutableTextField(
                        value = "Hajrudin Imamovic",
                        onValueChange = {},
                        keyboardOptions = KeyboardOptions.Default
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Username", style = Typography.labelMedium, color = Light, modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                    ImmutableTextField(
                        value = "hajruuudin",
                        onValueChange = {},
                        keyboardOptions = KeyboardOptions.Default
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Email", style = Typography.labelMedium, color = Light, modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                    ImmutableTextField(
                        value = "hajruuudin@gmail.com",
                        onValueChange = {},
                        keyboardOptions = KeyboardOptions.Default
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Favourite Category", style = Typography.labelMedium, color = Light, modifier = Modifier.padding(horizontal = 10.dp))
                    Spacer(modifier = Modifier.height(5.dp))
                    ImmutableTextField(
                        value = "Action",
                        onValueChange = {},
                        keyboardOptions = KeyboardOptions.Default
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(text = "Stats", style = Typography.labelMedium, color = Light, modifier = Modifier.padding(horizontal = 10.dp))

                    Spacer(modifier = Modifier.height(10.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(
                            text = "Movies Watched",
                            style = Typography.bodyMedium,
                            color = Light,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Buttons,
                                contentColor = Light
                            ),
                            modifier = Modifier.size(width = 80.dp, height = 40.dp)
                        ){
                            Text(text = "11", style = Typography.labelMedium, color = Light)
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ){
                        Text(
                            text = "Hours Watched",
                            style = Typography.bodyMedium,
                            color = Light,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        )

                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(15.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Buttons,
                                contentColor = Light
                            ),
                            modifier = Modifier.size(width = 80.dp, height = 40.dp)
                        ){
                            Text(text = "11", style = Typography.labelMedium, color = Light)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun ProfilePreview(){
//    ProfileScreen()
//}
