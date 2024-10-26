package com.aman.fakestorecom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.screens.home.HomeScreenLayout
import com.aman.fakestorecom.screens.home.bag.checkoutflow.CheckoutPage
import com.aman.fakestorecom.screens.home.bag.checkoutflow.PaymentMethodsScreen
import com.aman.fakestorecom.screens.home.bag.checkoutflow.SuccessScreen
import com.aman.fakestorecom.screens.item_display_screen.ItemDetailsScreen
import com.aman.fakestorecom.screens.loginsignup.MyForgetPasswordScreen
import com.aman.fakestorecom.screens.loginsignup.MyLoginScreen
import com.aman.fakestorecom.screens.loginsignup.MySignupScreen
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthViewModel


@Composable
fun App(authViewModel: AuthViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {

        composable(Routes.LOGIN_SCREEN) {
            MyLoginScreen(navController,authViewModel)
        }

        composable(Routes.SIGNUP_SCREEN) {
            MySignupScreen(navController,authViewModel)
        }

        composable(Routes.FORGET_PASSWORD_SCREEN) {
            MyForgetPasswordScreen(navController)
        }

        composable(Routes.HOME_SCREEN) {
            HomeScreenLayout(navController,authViewModel)
        }

        composable(Routes.ITEM_DISPLAY_SCREEN) {
            ItemDetailsScreen(navController)
        }
        composable(Routes.CHECKOUT_SCREEN) {
            CheckoutPage(navController)
        }
        composable(Routes.PAYMENT_SCREEN) {
            PaymentMethodsScreen(navController)
        }
        composable(Routes.SUCCESS_SCREEN) {
            SuccessScreen(navController)
        }
    }
}