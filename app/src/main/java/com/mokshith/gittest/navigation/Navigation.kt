package com.mokshith.gittest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mokshith.gittest.modelClasses.Category
import com.mokshith.gittest.screenComposabls.DetailsScreen
import com.mokshith.gittest.screenComposabls.LoginScreen
import com.mokshith.gittest.screenComposabls.MainScreen
import com.mokshith.gittest.screenComposabls.NycSchoolsScreen
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
        // to pass arguments
//        composable(route = Screen.DetailsScreen.route +"/{description}/{url}",
//            arguments = listOf(
//                navArgument("description") {
//                    type = NavType.StringType
//                },
//                navArgument("url") {
//                    type = NavType.StringType
//                }
//            )
//        ) {
//            val description = it.arguments?.getString("description")
//            val url = it.arguments?.getString("url")
//            DetailsScreen(navController,description,url)
//        }

        //to pass data class
        composable(route = Screen.DetailsScreen.route) {
            val category = navController.previousBackStackEntry?.savedStateHandle?.get<Category>("category")
            DetailsScreen(navController,category)
        }
        composable(route = Screen.NycSchoolScreen.route) {
            NycSchoolsScreen(navController)
        }
    }
}