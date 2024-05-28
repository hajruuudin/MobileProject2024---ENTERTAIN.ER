package com.example.entertainer.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.model.MovieCategories
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.EmailTextField
import com.example.entertainer.ui.components.GenericTextField
import com.example.entertainer.ui.components.LogoAndHeading
import com.example.entertainer.ui.components.PasswordTextField
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.DarkBg
import com.example.entertainer.ui.theme.DarkHard
import com.example.entertainer.ui.theme.InputBg
import com.example.entertainer.ui.theme.KubhmSansFont
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography

@Composable
fun SignUpScreen(
    navController: NavController
){
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var dropDownSelect by remember {
        mutableStateOf("")
    }

    var dropDownExpand by remember {
        mutableStateOf(false)
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.signupbg),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(
                rememberScrollState()
            ).padding(top = 50.dp)
        ){

            LogoAndHeading()

            Spacer(modifier = Modifier.height(height = 30.dp))

            Text(
                text = "Sign Up:",
                style = Typography.headlineLarge,
                color = Light
            )

            Spacer(modifier = Modifier.height(height = 30.dp))

            GenericTextField(
                value = name,
                onValueChange = {name = it},
                label = "Name",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(height = 20.dp))

            GenericTextField(
                value = surname,
                onValueChange = {surname = it},
                label = "Surname",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(height = 20.dp))

            GenericTextField(
                value = username,
                onValueChange = {username = it},
                label = "Username",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(height = 20.dp))

            EmailTextField(
                value = email,
                onValueChange = {email = it},
                label = "Email",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(height = 20.dp))


            PasswordTextField(
                value = password,
                onValueChange = {password = it},
                label = "Password",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(height = 20.dp))

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
                    -> MovieCategories.values().map {
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

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = {/*log in to do*/},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Buttons
                ),
                modifier = Modifier.width(width = 150.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Sign Up",
                    style = Typography.labelLarge,
                    color = Light
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            LogInComponent(navController)

            Spacer(modifier = Modifier.height(40.dp))

        }
    }
}

@Composable
private fun LogInComponent(
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

//@Preview(showBackground = true)
//@Composable
//fun SignUpPreview(){
//    SignUpScreen()
//}