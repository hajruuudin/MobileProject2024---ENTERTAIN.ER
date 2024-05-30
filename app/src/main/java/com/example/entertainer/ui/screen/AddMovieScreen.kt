package com.example.entertainer.ui.screen

import android.content.Context
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.data.Movie
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.GenericTextField
import com.example.entertainer.ui.components.Navbar
import com.example.entertainer.ui.components.convertToByteArray
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.DarkBg
import com.example.entertainer.ui.theme.DarkHard
import com.example.entertainer.ui.theme.InputBg
import com.example.entertainer.ui.theme.KubhmSansFont
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.ui.theme.UIBackground
import com.example.entertainer.viewmodel.AddMovieViewModel

@Composable
fun AddMovieScreen(
    navController: NavController,
    addMovieViewModel: AddMovieViewModel
){

    var dropDownSelect by remember { mutableStateOf("") }
    var dropDownExpand by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }

    var title by remember{mutableStateOf("")}
    var genre = when (dropDownSelect){
        "Action" -> MovieCategories.ACTION
        "Horror" -> MovieCategories.HORROR
        "Romance" -> MovieCategories.ROMANCE
        "Comedy" -> MovieCategories.COMEDY
        else -> MovieCategories.SCIFI
    }
    var director by remember { mutableStateOf("") }
    var duration by remember { mutableStateOf("") }
    var actors by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }

    val context = LocalContext.current

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

                Text(text = "Add Movie", style = Typography.labelMedium, color = Light)
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
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                Text(
                    text = "Add a Movie",
                    style = Typography.headlineLarge,
                    color = Light
                )

                Spacer(modifier = Modifier.height(30.dp))

                MovieImage(
                    imageUri = imageUri,
                    onImageUriChanged = { newUri -> imageUri = newUri },
                    bitmap = bitmap,
                    onBitmapChanged = { newBitmap -> bitmap = newBitmap },
                    context = context
                )

                Spacer(modifier = Modifier.height(30.dp))

                GenericTextField(
                    value = title,
                    onValueChange = {title = it},
                    label = "Title",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )
                
                Spacer(modifier = Modifier.height(10.dp))

                Box()
                {
                    TextField(
                        modifier = Modifier
                            .border(width = 3.dp, color = DarkHard, shape = RoundedCornerShape(15.dp)),
                        value = dropDownSelect,
                        label = {
                            Text(
                                text = "Favourite Category",
                                color = Light,
                                fontFamily = KubhmSansFont,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        },
                        trailingIcon = {
                            Icon(
                                painterResource(id = R.drawable.dropdown),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(20.dp)
                                    .clickable {
                                        dropDownExpand = !dropDownExpand
                                    }

                            )
                        },
                        readOnly = true,
                        onValueChange = {},
                        shape = RoundedCornerShape(15.dp),
                        textStyle = TextStyle.Default.copy(
                            fontFamily = KubhmSansFont,
                            fontSize = 20.sp
                        ),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = DarkBg,
                            focusedContainerColor = InputBg,
                            focusedLabelColor = DarkBg,
                            focusedTextColor = Light,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    DropdownMenu(
                        expanded = dropDownExpand,
                        modifier = Modifier.width(280.dp),
                        onDismissRequest = { dropDownExpand = false}) {
                        -> MovieCategories.entries.map {
                        DropdownMenuItem(
                            colors = MenuDefaults.itemColors(
                                textColor = Light
                            ),
                            text = { Text(text = it.value)},
                            onClick = {
                                dropDownSelect = it.value;
                                dropDownExpand = false
                            })
                    }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                GenericTextField(
                    value = director,
                    onValueChange = {director = it},
                    label = "Director",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                GenericTextField(
                    value = duration,
                    onValueChange = {duration = it},
                    label = "Duration",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                GenericTextField(
                    value = actors,
                    onValueChange = {actors = it},
                    label = "Actors",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                GenericTextField(
                    value = description,
                    onValueChange = {description = it},
                    label = "Description",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Next
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                GenericTextField(
                    value = rating,
                    onValueChange = {rating = it},
                    label = "Actors",
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {
                              addMovieViewModel.addMovie(
                                  Movie(
                                      title = title,
                                      genre = genre,
                                      actors = actors,
                                      director = director,
                                      rating = rating,
                                      duration = duration.toInt(),
                                      image = bitmap?.let { it1 -> convertToByteArray(it1) }
                                  )
                              )
                        Toast
                            .makeText(context, "Movie added!", Toast.LENGTH_LONG).show()
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Buttons
                    ),
                    shape = RoundedCornerShape(15.dp),
                    modifier = Modifier.size(width = 200.dp, height = 50.dp)
                ) {
                    Text(
                        text = "Add Movie!",
                        style = Typography.labelMedium
                    )
                }
            }
        }
    }
}

@Composable
fun MovieImage(
    imageUri: Uri?,
    onImageUriChanged: (Uri?) -> Unit,
    bitmap: Bitmap?,
    onBitmapChanged: (Bitmap?) -> Unit,
    context: Context
){
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        onImageUriChanged(uri)
    }

    LaunchedEffect(imageUri) {
        imageUri?.let { uri ->
            val newBitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                ImageDecoder.decodeBitmap(source)
            }
            onBitmapChanged(newBitmap)
        }
    }

    if (bitmap != null) {
        Image(
            bitmap = bitmap.asImageBitmap(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(20.dp))
        )
    } else {
        Image(
            painter = painterResource(id = R.drawable.defaultcover),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clip(RoundedCornerShape(20.dp))
                .clickable { launcher.launch("image/*")
                }
        )
    }
}

