package com.example.entertainer.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.entertainer.R
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemInfoScreen() {
    Scaffold(
        bottomBar = {
            Navbar(
                onHomeClick = {},
                onMoviesClick = {},
                onWatchlistClick = {},
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
        ){
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ){
                Image(
                    painter = painterResource(id = R.drawable.defaultcover),
                    contentDescription = null
                )

                Text(
                    text = "Movie Title",
                    style = Typography.bodyMedium,
                    color = Light
                )
            }

        }
    }


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ItemInfoPreview()
{
    ItemInfoScreen()
}