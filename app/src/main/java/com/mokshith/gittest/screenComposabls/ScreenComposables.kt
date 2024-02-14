package com.mokshith.gittest.screenComposabls

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mokshith.gittest.R
import com.mokshith.gittest.composableComponents.BoldTextComponents
import com.mokshith.gittest.composableComponents.NormalTextComponents
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSample
import com.mokshith.gittest.composableComponents.SimpleOutlinedTextFieldSamplePassword

//@Composable
//fun MealsCategoryScreen() {
//    val viewModel: MealsCategoriesViewModel = viewModel()
//    Text(
//        text = "Hello Mokshith"
//    )
//}

@Composable
fun SignUpScreen() {
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalTextComponents(value = stringResource(id = R.string.hello))
            BoldTextComponents(value = "Create an Account")
            Spacer(modifier = Modifier.heightIn(24.dp))
            SimpleOutlinedTextFieldSample(
                value = "First Name",
                KeyboardOptions(keyboardType = KeyboardType.Text),
                Icons.Rounded.Person
            )
            SimpleOutlinedTextFieldSample(
                value = "Last Name",
                KeyboardOptions(keyboardType = KeyboardType.Text),
                Icons.Rounded.Person
            )
            SimpleOutlinedTextFieldSample(
                value = "Email",
                KeyboardOptions(keyboardType = KeyboardType.Email),
                Icons.Rounded.Email
            )
            //password outlined text
            SimpleOutlinedTextFieldSamplePassword(
                value = "Password",
                imageIcon = Icons.Rounded.Lock
            )
        }
    }
}


@Preview
@Composable
fun DefaultPreviewOfSignUpScreen() {
    SignUpScreen()
}


