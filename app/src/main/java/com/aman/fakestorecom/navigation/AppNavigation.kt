package com.aman.fakestorecom.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.screens.favorites.FavoritesScreen
import com.aman.fakestorecom.screens.home.HomeScreen
import com.aman.fakestorecom.screens.loginsignup.MyForgetPasswordScreen
import com.aman.fakestorecom.screens.loginsignup.MyLoginScreen
import com.aman.fakestorecom.screens.loginsignup.MySignupScreen
import com.aman.fakestorecom.screens.profile.ProfileScreen
import com.aman.fakestorecom.screens.shop.ShopScreen


@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.LOGIN_SCREEN) {
        composable(Routes.LOGIN_SCREEN) {
            MyLoginScreen(navController)
        }
        composable(Routes.SIGNUP_SCREEN) {
            MySignupScreen(navController)
        }
        composable(Routes.FORGET_PASSWORD_SCREEN) {
            MyForgetPasswordScreen(navController)
        }
        composable(Routes.HOME_SCREEN) {
            HomeScreen(navController)
        }
        composable(Routes.SHOP_SCREEN) {
            ShopScreen(navController)
        }
        composable(Routes.FAVORITE_SCREEN) {
            FavoritesScreen(navController)
        }
        composable(Routes.PROFILE_SCREEN) {
            ProfileScreen(navController)
        }
    }
}