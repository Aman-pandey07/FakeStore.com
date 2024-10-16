package com.aman.fakestorecom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.screens.loginsignup.MyForgetPasswordScreen
import com.aman.fakestorecom.screens.loginsignup.MyLoginScreen
import com.aman.fakestorecom.screens.loginsignup.MySignupScreen


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LoginScreen) {
        composable(Routes.LoginScreen) {
            MyLoginScreen(navController)
        }
        composable(Routes.SignupScreen) {
            MySignupScreen(navController)
        }
        composable(Routes.ForgetPasswordScreen) {
            MyForgetPasswordScreen(navController)
        }
    }
}