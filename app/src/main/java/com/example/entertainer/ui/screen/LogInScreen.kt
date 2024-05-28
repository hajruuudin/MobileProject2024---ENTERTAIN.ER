package com.example.entertainer.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entertainer.R
import com.example.entertainer.ui.Screen
import com.example.entertainer.ui.components.EmailTextField
import com.example.entertainer.ui.components.LogoAndHeading
import com.example.entertainer.ui.components.PasswordTextField
import com.example.entertainer.ui.theme.Buttons
import com.example.entertainer.ui.theme.KubhmSansFont
import com.example.entertainer.ui.theme.Light
import com.example.entertainer.ui.theme.Typography


@Composable
fun LogInScreen(
    navController: NavController
){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(id = R.drawable.loginbg),
            contentDescription = "bglogin",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Showing the logo:
            LogoAndHeading()

            Spacer(modifier = Modifier.height(50.dp))

            // Main part: Log In Form
            Text(
                text = "Log In",
                style = Typography.headlineLarge,
                color = Light
            )

            Spacer(modifier = Modifier.height(20.dp))

            EmailTextField(
                value = email,
                onValueChange = {email = it},
                label = "Email",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                )
            )

            Spacer(modifier = Modifier.height(15.dp))

            PasswordTextField(
                value = password,
                onValueChange = {password = it},
                label = "Password",
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {/*log in to do*/},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Buttons
                ),
                modifier = Modifier.width(width = 150.dp),
                shape = RoundedCornerShape(15.dp)
            ) {
                Text(
                    text = "Log In",
                    style = Typography.labelLarge,
                    color = Light
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            SignUpComponent(navController)
        }
    }
}



@Composable
private fun SignUpComponent(
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






//// Preview for the entire screen
//@Preview(showBackground = true)
//@Composable
//fun LogInScreenPreview(){
//    LogInScreen()
//}