package com.example.entertainer

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.entertainer.data.DatabaseProvider
import com.example.entertainer.ui.NavGraph
import com.example.entertainer.ui.theme.EntertainerTheme
import com.example.entertainer.viewmodel.HomeScreenModelFactory
import com.example.entertainer.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val movieDao = DatabaseProvider.getDatabase(this).movieDao()
        val userMovieDao = DatabaseProvider.getDatabase(this).userMovieDao()
        val viewModel = ViewModelProvider(this, HomeScreenModelFactory(movieDao, userMovieDao)).get(HomeScreenViewModel::class.java)

        setContent {
            EntertainerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavGraph(navController = navController, viewModel)
                }
            }
        }
    }
}
