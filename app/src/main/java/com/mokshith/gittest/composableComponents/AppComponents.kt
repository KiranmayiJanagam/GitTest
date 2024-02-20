package com.mokshith.gittest.composableComponents

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mokshith.gittest.R
import com.mokshith.gittest.navigation.Screen

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
            focusedContainerColor = colorResource(id = R.color.white),

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
            focusedContainerColor = colorResource(id = R.color.white),

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
            val imageVector = if (passwordVisible) {
                Icons.Filled.ArrowBack
            } else {
                Icons.Filled.ArrowForward
            }
            val description = if (passwordVisible) {
                "Hide Password"
            } else {
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
fun CheckBoxComponent(navController: NavController, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val checkedState = remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { isChecked ->
                checkedState.value = isChecked
            },
            colors = CheckboxDefaults.colors(
                uncheckedColor = Color.Green,
                checkedColor = Color.Yellow,
                checkmarkColor = Color.Magenta
            )
        )
        ClickableTextComponent(navController = navController, onItemClick)
    }
}

@Composable
fun ClickableTextComponent(navController: NavController, onItemClick: (String) -> Unit) {
    val initialText = "By continuing you accept our "
    val privacyPolicyText = "Privacy Policy "
    val andText = "and "
    val termsToUseText = "Terms of Use"
    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = termsToUseText, annotation = termsToUseText)
            append(termsToUseText)
        }
    }
    ClickableText(text = annotatedString, onClick = {
        annotatedString.getStringAnnotations(it, it).firstOrNull()?.also { span ->
            Log.e("TAG", "ClickableTextComponent: $span")
            if (span.item == termsToUseText) {
                //two ways to send the data from one Composable to another Composable
                navController.navigate(Screen.TermsOfUse.withArgs("Terms and Conditions", " Body"))
                //navController.navigate(Screen.TermsOfUse.route + "/ Terms and Conditions/ Body")
            } else if (span.item == privacyPolicyText) {
                //this below onItemClick will handover the action to the parent composable
                onItemClick("privacyPolicyText")
                // the below navigate does the work here it self
                //navController.navigate(Screen.PrivacyPolicy.route)
            }
        }
    })
}


@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                //to use gradient colors we need to use brush
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.colorSecondary),
                            colorResource(id = R.color.colorPrimary)
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = value,
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun ClickableTextComponentSingUpLogin(
    navController: NavController,
    initialText: String,
    finalText: String,
    onItemClick: (String) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        val annotatedString = buildAnnotatedString {
            append(initialText)
            withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
                pushStringAnnotation(tag = finalText, annotation = finalText)
                append(finalText)
            }
        }
        ClickableText(text = annotatedString, onClick = {
            annotatedString.getStringAnnotations(it, it).firstOrNull()?.also { span ->
                Log.e("TAG", "ClickableTextComponent: $span")
                if (span.item == "Login") {
                    navController.navigate(Screen.LogIn.route)
                } else {
                    navController.navigate(Screen.SignUp.route)
                }
            }
        })

    }
}


@Composable
fun DividerComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = colorResource(id = R.color.colorGray), thickness = 1.dp
        )

        Text(
            text = "or", modifier = Modifier.padding(
                10.dp
            )
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), color = colorResource(id = R.color.colorGray), thickness = 1.dp
        )

    }
}

@Composable
fun UnderLineTextComponents(value: String, onClick: () -> Unit) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp)
            .clickable {
                onClick()
            },
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline,
    )
}