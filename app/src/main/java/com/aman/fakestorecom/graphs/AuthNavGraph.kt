//package com.aman.fakestorecom.graphs
//
//
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//
//
//fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.AUTHENTICATION,
//        startDestination = AuthScreen.SPLASH.route
//    ) {
//
//        composable(route = AuthScreen.SPLASH.route) {
//            SplashScreen(navController = navController)
//        }
//
//        composable(route = AuthScreen.Login.route) {
//            LoginScreen(navController = navController)
//        }
//        composable(route = AuthScreen.SignUp.route) {
//            RegisterScreen(navController = navController)
//        }
//        composable(route = AuthScreen.Forgot.route) {
//            ForgotPasswordScreen(navController = navController)
//        }
//    }
//}
//
//sealed class AuthScreen(val route: String) {
//    object SPLASH : AuthScreen(route = "SPLASH")
//    object Login : AuthScreen(route = "LOGIN")
//    object SignUp : AuthScreen(route = "SIGN_UP")
//    object Forgot : AuthScreen(route = "FORGOT")
//}