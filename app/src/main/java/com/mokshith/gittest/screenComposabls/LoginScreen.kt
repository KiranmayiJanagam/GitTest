package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.mokshith.gittest.R
import com.mokshith.gittest.composableComponents.BoldTextComponents
import com.mokshith.gittest.composableComponents.ButtonComponent
import com.mokshith.gittest.composableComponents.ClickableTextComponentSingUpLogin
import com.mokshith.gittest.composableComponents.NormalTextComponents
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSample
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSamplePassword
import com.mokshith.gittest.composableComponents.UnderLineTextComponents
import com.mokshith.gittest.navigation.Screen

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Surface(
        color = Color.White, modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxSize()
        ) {
            NormalTextComponents(value = stringResource(id = R.string.hello))
            BoldTextComponents(value = "Welcome Back")
            Spacer(modifier = Modifier.heightIn(24.dp))
            SimpleOutlinedTextFieldSample(value = "First Name",
                KeyboardOptions(keyboardType = KeyboardType.Text),
                Icons.Rounded.Person,
                email,
                onValueChange = { email = it })
            SimpleOutlinedTextFieldSamplePassword(value = "Password",
                imageIcon = Icons.Rounded.Lock,
                password,
                onValueChange = { password = it })

            Spacer(modifier = Modifier.heightIn(20.dp))

            UnderLineTextComponents(value = "Forgot your password", onClick = {

            })

            Spacer(modifier = Modifier.heightIn(40.dp))

            ButtonComponent(value = "Login", onItemClick = {
                navController.navigate(Screen.MainScreen.route)
            })

            ClickableTextComponentSingUpLogin(navController = navController,
                initialText = "Don't have the account yet? ",
                finalText = " Register",
                onItemClick = {

                })
        }
    }
}

@Preview
@Composable
fun DefaultPreviewOfLoginScreen() {
    LoginScreen(navController = rememberNavController())
}
