package com.mokshith.gittest.composableComponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mokshith.gittest.R

@Composable
fun NormalTextComponents(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun BoldTextComponents(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SimpleOutlinedTextFieldSample(
    value: String,
    keyboardOptions: KeyboardOptions,
    imageIcon: ImageVector
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            //setting the text field background when it is focused
            focusedContainerColor = colorResource(id = R.color.colorGray),

            //setting the text field background when it is unfocused or initial state
            unfocusedContainerColor = colorResource(id = R.color.ashColor),

            //setting the text field background when it is disabled
            disabledContainerColor = colorResource(id = R.color.colorGray),
        ),
        value = text,
        onValueChange = { text = it },
        label = { Text(value) },
        maxLines = 1,
        keyboardOptions = keyboardOptions,
        leadingIcon = {
            Icon(imageIcon, contentDescription = "Localized description")
        }
    )
}

@Composable
fun SimpleOutlinedTextFieldSamplePassword(
    value: String,
    imageIcon: ImageVector
) {
    var passwordVisible by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            //setting the text field background when it is focused
            focusedContainerColor = colorResource(id = R.color.colorGray),

            //setting the text field background when it is unfocused or initial state
            unfocusedContainerColor = colorResource(id = R.color.ashColor),

            //setting the text field background when it is disabled
            disabledContainerColor = colorResource(id = R.color.colorGray),
        ),
        value = password,
        onValueChange = { password = it },
        label = { Text(value) },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(imageIcon, contentDescription = "Localized description")
        },
        trailingIcon = {
            val imageVector  = if (passwordVisible){
                Icons.Filled.ArrowBack
            } else {
                Icons.Filled.ArrowForward
            }
            val description = if (passwordVisible){
                "Hide Password"
            }else{
                "Show Password"
            }
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(){
    Row (){

    }
}