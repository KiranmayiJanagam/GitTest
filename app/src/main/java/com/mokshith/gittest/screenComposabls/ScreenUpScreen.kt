package com.mokshith.gittest.screenComposabls

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokshith.gittest.R
import com.mokshith.gittest.composableComponents.BoldTextComponents
import com.mokshith.gittest.composableComponents.ButtonComponent
import com.mokshith.gittest.composableComponents.CheckBoxComponent
import com.mokshith.gittest.composableComponents.ClickableTextComponentSingUpLogin
import com.mokshith.gittest.composableComponents.DividerComponent
import com.mokshith.gittest.composableComponents.NormalTextComponents
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSample
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSamplePassword
import com.mokshith.gittest.navigation.Screen
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay

@Composable
fun SignUpScreen(navController: NavController) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)) {
            NormalTextComponents(value = stringResource(id = R.string.hello))
            BoldTextComponents(value = "Create an Account")
            Spacer(modifier = Modifier.heightIn(24.dp))
            SimpleOutlinedTextFieldSample(
                value = "First Name",
                KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                Icons.Rounded.Person,
                firstName,
                onValueChange = { firstName = it }
            )
            SimpleOutlinedTextFieldSample(
                value = "Last Name",
                KeyboardOptions(keyboardType = KeyboardType.Text),
                Icons.Rounded.Person,
                lastName,
                onValueChange = { lastName = it }
            )
            SimpleOutlinedTextFieldSample(
                value = "Email",
                KeyboardOptions(keyboardType = KeyboardType.Email),
                Icons.Rounded.Email,
                email,
                onValueChange = { email = it }
            )
            //password outlined text
            SimpleOutlinedTextFieldSamplePassword(
                value = "Password",
                imageIcon = Icons.Rounded.Lock,
                password,
                onValueChange = { password = it }
            )
            CheckBoxComponent(navController = navController, onItemClick = {
                navController.navigate(Screen.PrivacyPolicy.route)
            })

            Spacer(modifier = Modifier.heightIn(80.dp))

            ButtonComponent(value = "Register", onItemClick = {
                if (firstName.isNotEmpty()){

                }
            })

            Spacer(modifier = Modifier.heightIn(20.dp))

            DividerComponent()

            ClickableTextComponentSingUpLogin(
                navController = navController,
                initialText = "Already have an account? ",
                finalText = "Login",
                onItemClick = {
                    navController.navigate(Screen.LogIn.route)
                }
            )
            
            
            Greetings()
        }
    }
}

@Composable
fun Greetings() {

    val context = LocalContext.current
    val x by remember {
        mutableStateOf(true)
    }
//    SideEffect {
//
//    }
//
    LaunchedEffect(key1 = Unit) {
        delay(1000)
        Toast.makeText(context,"Hello Mokshith",Toast.LENGTH_SHORT).show()
    }


    DisposableEffect(key1 = Unit) {
        //delay(1000)
        onDispose {

        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen(navController = rememberNavController())
}


