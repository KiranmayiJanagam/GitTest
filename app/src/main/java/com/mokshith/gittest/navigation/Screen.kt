package com.mokshith.gittest.navigation

sealed class Screen(val route : String) {
    data object SignUp: Screen("sign_up_screen")
    data object TermsOfUse: Screen("terms_of_use_screen")

    //this is for only mamdatory arguments
    fun withArgs(vararg args :String): String{
        return buildString {
            append(route)
            args.forEach {args ->
                append("/$args")
            }
        }
    }

    data object PrivacyPolicy: Screen("privacy_policy")

    data object LogIn: Screen("log_in")
}