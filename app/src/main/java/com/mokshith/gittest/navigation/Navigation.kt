package com.mokshith.gittest.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mokshith.gittest.screenComposabls.LoginScreen
import com.mokshith.gittest.screenComposabls.MainScreen
import com.mokshith.gittest.screenComposabls.PrivacyPolicyScreen
import com.mokshith.gittest.screenComposabls.SignUpScreen
import com.mokshith.gittest.screenComposabls.TermsAndConditionScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SignUp.route
    ) {
        composable(route = Screen.SignUp.route) {
            SignUpScreen(navController = navController)
        }
        composable(route = Screen.TermsOfUse.route + "/{title}/{body}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                },
                navArgument("body") {
                    type = NavType.StringType
                }
            )
        ) {
            val title = it.arguments?.getString("title")
            val body = it.arguments?.getString("body")
            TermsAndConditionScreen(title, body, navController = navController)
        }
        composable(route = Screen.PrivacyPolicy.route) {
            PrivacyPolicyScreen(navController)
        }
        composable(route = Screen.LogIn.route) {
            LoginScreen(navController)
        }
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController)
        }
    }
}