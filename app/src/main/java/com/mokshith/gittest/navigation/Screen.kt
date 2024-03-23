package com.mokshith.gittest.navigation

sealed class Screen(val route: String) {
    object SignUp : Screen("sign_up_screen")
    object TermsOfUse : Screen("terms_of_use_screen")

    //this is for only mamdatory arguments
//    fun withArgs(vararg args: String): String {
//        return buildString {
//            append(route)
//            args.forEach { args ->
//                append("/$args")
//            }
//        }
//    }

    object PrivacyPolicy : Screen("privacy_policy")
    object LogIn : Screen("log_in")
    object MainScreen : Screen("main_screen")
    object DetailsScreen : Screen("details_screen")

    object NycSchoolScreen : Screen("nyc_school_screen")
}