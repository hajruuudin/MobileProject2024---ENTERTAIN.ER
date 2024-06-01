package com.example.entertainer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.data.Movie
import com.example.entertainer.data.UserMovie
import com.example.entertainer.ui.theme.DarkBg
import com.example.entertainer.ui.theme.DarkHard
import com.example.entertainer.ui.theme.InputBg
import com.example.entertainer.ui.theme.KubhmSansFont
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.NavbarBg
import com.example.entertainer.ui.theme.Typography
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.theme.Action
import com.example.entertainer.ui.theme.Comedy
import com.example.entertainer.ui.theme.DarkSoft
import com.example.entertainer.ui.theme.Horror
import com.example.entertainer.ui.theme.Romance
import com.example.entertainer.ui.theme.SciFi

/* Logo and Heading composable for the log in page */
@Composable
fun LogoAndHeading() {
    Image(
        painter = painterResource(id = R.drawable.logowhite),
        contentDescription = "logo",
        modifier = Modifier.width(width = 250.dp)
    )

    Spacer(modifier = Modifier.height(height = 10.dp))

    Text(
        text = "Your movie tracker!",
        color = Light,
        style = Typography.headlineSmall
    )
}

@Composable
fun SignUpComponent(
    navController: NavController
) {
    Text(
        text = "Don't have an account?",
        style = Typography.bodySmall,
        color = Light
    )

    TextButton(onClick = {navController.navigate(Screen.SignUpScreen.route)}) {
        Text(
            text = "Sign Up!",
            fontSize = 20.sp,
            fontFamily = KubhmSansFont,
            fontWeight = FontWeight.Bold,
            color = Light
        )
    }
}

@Composable
fun LogInComponent(
    navController: NavController
) {
    Text(
        text = "Have an account?",

        style = Typography.bodySmall,
        color = Light
    )

    TextButton(onClick = {navController.navigate(Screen.LogInScreen.route)}) {
        Text(
            text = "Log In!",
            fontSize = 20.sp,
            fontFamily = KubhmSansFont,
            fontWeight = FontWeight.Bold,
            color = Light
        )
    }
}

/* Text fields for all pages */
@Composable
fun GenericTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        modifier = Modifier
            .border(width = 3.dp, color = DarkHard, shape = RoundedCornerShape(15.dp)),
        value = value,
        label = {
            Text(
                text = label,
                color = Light,
                fontFamily = KubhmSansFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        onValueChange = onValueChange,
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle.Default.copy(
            fontFamily = KubhmSansFont,
            fontSize = 20.sp,
            color = Light
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = DarkBg,
            focusedContainerColor = InputBg,
            focusedLabelColor = DarkBg,
            focusedTextColor = Light,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun ImmutableTextField(
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        modifier = Modifier
            .border(width = 3.dp, color = DarkHard, shape = RoundedCornerShape(15.dp)),
        value = value,
        readOnly = true,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(15.dp),
        textStyle = TextStyle.Default.copy(
            fontFamily = KubhmSansFont,
            fontSize = 20.sp,
            color = Light
        ),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = DarkBg,
            focusedContainerColor = InputBg,
            focusedLabelColor = DarkBg,
            focusedTextColor = Light,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun GenericSmallTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        modifier = Modifier
            .border(width = 3.dp, color = DarkSoft, shape = RoundedCornerShape(15.dp))
            .width(200.dp),
        value = value,
        label = {
            Text(
                text = label,
                color = Light,
                fontFamily = KubhmSansFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        onValueChange = onValueChange,
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
        ),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun EmailTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions
) {
    TextField(
        modifier = Modifier
            .border(width = 3.dp, color = DarkHard, shape = RoundedCornerShape(15.dp)),
        value = value,
        label = {
            Text(
                text = label,
                color = Light,
                fontFamily = KubhmSansFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        onValueChange = onValueChange,
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
        ),
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions,
) {
    var visibility by remember { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .border(width = 3.dp, color = DarkHard, shape = RoundedCornerShape(15.dp)),
        value = value,
        trailingIcon =
        {
            Icon(
                modifier = Modifier
                    .size(30.dp)
                    .clickable {
                        visibility = !visibility
                    },
                painter = painterResource(id = R.drawable.eye),
                contentDescription = null,
                tint = Light
            )
        },
        label = {
            Text(
                text = label,
                color = Light,
                fontFamily = KubhmSansFont,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        },
        visualTransformation = if (!visibility) PasswordVisualTransformation() else VisualTransformation.None,
        onValueChange = onValueChange,
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
        ),
        keyboardOptions = keyboardOptions,
    )
}

/* Navbar composable for all pages with navigation routes */
@Composable
fun Navbar(
    onHomeClick : () -> Unit,
    onMoviesClick : () -> Unit,
    onWatchlistClick : () -> Unit,
    onProfileClick : () -> Unit,
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(NavbarBg),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.homeicon),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    onHomeClick()
                }

        )

        Image(
            painter = painterResource(id = R.drawable.movies),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    onMoviesClick()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.watchlist),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    onWatchlistClick()
                }
        )

        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
                .clickable {
                    onProfileClick()
                }
        )
    }
}

/* Movie cards: Large, Medium, Small */
@Composable
fun MovieCardLarge(
    movie: Movie,
    onCardClick: () -> Unit,
){
    Card(
        colors = CardDefaults.cardColors(
            containerColor = DarkBg
        ),
        modifier = Modifier
            .width(350.dp)
            .clickable {
                onCardClick()
            }
    ) {
        Row {
            if(movie.image != null) {
                Image(
                    bitmap = convertToImageBitmap(movie.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 160.dp, height = 250.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.defaultcover),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 160.dp, height = 250.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = movie.title,
                    style = Typography.headlineSmall,
                    color = Light
                )

                Spacer(modifier = Modifier.height(20.dp))

                val genre = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Genre: ")
                    }
                    append(movie.genre.value)
                }
                Text(text = genre, color = Light, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(5.dp))

                val duration = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Duration: ")
                    }
                    append(movie.duration.toString())
                }
                Text(text = duration, color = Light, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(5.dp))

                val director = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Director: ")
                    }
                    append(movie.director)
                }
                Text(text = director, color = Light, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(5.dp))

                val rating = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Rating: ")
                    }
                    append(movie.rating)
                }
                Text(text = rating, color = Light, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun MovieCardMedium(
    movie: Movie,
    onCardClick: () -> Unit
){
    Card(
        colors = when(movie.genre.value){
            "Action" -> CardDefaults.cardColors(containerColor = Action)
            "Romance" -> CardDefaults.cardColors(containerColor = Romance)
            "Comedy" -> CardDefaults.cardColors(containerColor = Comedy)
            "Horror" -> CardDefaults.cardColors(containerColor = Horror)
            else -> CardDefaults.cardColors(containerColor = SciFi)
        },
        modifier = Modifier
            .width(350.dp)
            .clickable {
                onCardClick()
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(movie.image != null) {
                Image(
                    bitmap = convertToImageBitmap(movie.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 140.dp, height = 200.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.defaultcover),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 140.dp, height = 200.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = movie.title,
                    style = Typography.headlineSmall,
                    color = Light
                )

                Spacer(modifier = Modifier.height(15.dp))

                val genre = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Genre: ")
                    }
                    append(movie.genre.value)
                }
                Text(text = genre, color = Light, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(5.dp))

                val duration = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Duration: ")
                    }
                    append(movie.duration.toString())
                }
                Text(text = duration, color = Light, fontSize = 18.sp)

                Spacer(modifier = Modifier.height(5.dp))

                val rating = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Rating: ")
                    }
                    append(movie.rating)
                }
                Text(text = rating, color = Light, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun MovieCardSmall(
    movie: Movie,
    onCardClick: () -> Unit
){
    Card(
        colors = when(movie.genre.value){
            "Action" -> CardDefaults.cardColors(containerColor = Action)
            "Romance" -> CardDefaults.cardColors(containerColor = Romance)
            "Comedy" -> CardDefaults.cardColors(containerColor = Comedy)
            "Horror" -> CardDefaults.cardColors(containerColor = Horror)
            else -> CardDefaults.cardColors(containerColor = SciFi)
        },
        modifier = Modifier
            .width(300.dp)
            .height(120.dp)
            .clickable {
                onCardClick()
            }
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            if(movie.image != null) {
                Image(
                    bitmap = convertToImageBitmap(movie.image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 80.dp, height = 120.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.defaultcover),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 80.dp, height = 120.dp)
                        .clip(shape = RoundedCornerShape(15.dp)),
                    contentScale = ContentScale.FillBounds
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            ) {
                Text(
                    text = movie.title,
                    style = Typography.headlineSmall,
                    color = Light
                )

                Spacer(modifier = Modifier.height(10.dp))

                val genre = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Genre: ")
                    }
                    append(movie.genre.value)
                }
                Text(text = genre, color = Light, fontSize = 16.sp)

                val duration = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Duration: ")
                    }
                    append(movie.duration.toString())
                }
                Text(text = duration, color = Light, fontSize = 16.sp)


                val rating = buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = KubhmSansFont, fontWeight = FontWeight.Bold)){
                        append("Rating: ")
                    }
                    append(movie.rating)
                }
                Text(text = rating, color = Light, fontSize = 16.sp)
            }
        }
    }
}


/* Previews used for the cards
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieCardLargePreview(){
    MovieCardLarge(
        onCardClick = {},
        title = "Fast and Furious 7",
        genre = MovieCategories.ACTION,
        duration = 3,
        director = "James Wan",
        rating = "5 stars"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieCardMediumPreview(){
    MovieCardMedium(
        onCardClick = {},
        title = "Fast and Furious 7",
        genre = MovieCategories.ACTION,
        duration = 3,
        rating = "5 stars"
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieCardSmallPreview(){
    MovieCardSmall(
        onCardClick = {},
        title = "Fast and Furious 7",
        genre = MovieCategories.ACTION,
        duration = 3,
        rating = "5 stars"
    )
}
*/