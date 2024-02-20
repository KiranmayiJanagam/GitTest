package com.mokshith.gittest.screenComposabls

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun PrivacyPolicyScreen(navController: NavHostController) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Green)) {
        Column(modifier = Modifier) {

        }
        Text(text = "Privacy Policy")
    }
}