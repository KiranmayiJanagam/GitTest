package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun TermsAndConditionScreen(value: String?, body: String?, navController: NavHostController) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red)
            .padding(16.dp)
    ) {
        if (value != null) {
            Text(text = value+body)
        }
    }
}

@Preview
@Composable
fun TermsAndConditionScreenPreview(){
    Text(text = "")
    //NormalTextComponents("Terms and Conditions")
}