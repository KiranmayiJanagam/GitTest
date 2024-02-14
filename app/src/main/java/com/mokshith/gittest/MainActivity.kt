package com.mokshith.gittest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mokshith.gittest.ui.theme.GitTestTheme
import com.mokshith.gittest.screenComposabls.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GitTestTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    Surface(modifier = Modifier.background(Color.Green)) {
                        SignUpScreen()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GitTestTheme {
        SignUpScreen()
    }
}