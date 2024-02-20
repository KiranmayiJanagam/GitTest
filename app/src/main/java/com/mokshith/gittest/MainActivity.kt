package com.mokshith.gittest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mokshith.gittest.navigation.Navigation
import com.mokshith.gittest.ui.theme.GitTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitTestTheme {
                Navigation()
            }
        }
    }
}