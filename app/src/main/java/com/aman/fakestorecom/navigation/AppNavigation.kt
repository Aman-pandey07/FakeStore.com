package com.aman.fakestorecom.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aman.fakestorecom.screens.ProductDetailScreen
import com.aman.fakestorecom.screens.ProductListScreen
import com.aman.fakestorecom.screens.home.HomeScreenLayout
import com.aman.fakestorecom.screens.home.bag.checkoutflow.CheckoutPage
import com.aman.fakestorecom.screens.home.bag.checkoutflow.PaymentMethodsScreen
import com.aman.fakestorecom.screens.home.bag.checkoutflow.SuccessScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.MyOrdersScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.OrderDetailsScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.ProfileScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.SettingScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.AddShippingAddressScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.Address
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.ShippingAddressesScreen
import com.aman.fakestorecom.screens.home.shop.ShopCatListListScreen
import com.aman.fakestorecom.screens.item_display_screen.ItemDetailsScreen
import com.aman.fakestorecom.screens.loginsignup.MyForgetPasswordScreen
import com.aman.fakestorecom.screens.loginsignup.MyLoginScreen
import com.aman.fakestorecom.screens.loginsignup.MySignupScreen
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthViewModel
import okhttp3.Route

val dummyAddresses = listOf(
    Address(
        name = "Jane Doe",
        addressLine = "3 Newbridge Court",
        city = "Chino Hills",
        state = "CA",
        zipCode = "91709",
        country = "United States"
    ),
    Address(
        name = "John Doe",
        addressLine = "3 Newbridge Court",
        city = "Chino Hills",
        state = "CA",
        zipCode = "91709",
        country = "United States"
    ),
    Address(
        name = "John Doe",
        addressLine = "51 Riverside",
        city = "Chino Hills",
        state = "CA",
        zipCode = "91709",
        country = "United States"
    )
)
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
        composable(Routes.PRODUCT_LIST_SCREEN) {
            ProductListScreen(navController)
        }

        composable(
            Routes.ITEM_DISPLAY_SCREEN,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) {backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            ItemDetailsScreen(navController,productId)
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

        composable(
            route = Routes.PRODUCT_DETAIL_SCREEN,
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId") ?: 0
            Log.d("Navigation", "Navigating to ProductDetailScreen with productId: $productId")
            ProductDetailScreen(navController, productId)
        }

        composable(
            route = "shopcatlistlistscreen/{categoryName}",
            arguments = listOf(navArgument("categoryName") {type = NavType.StringType})
        ) {backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("categoryName")?: "Unknown"
            ShopCatListListScreen(navController,categoryName = categoryName)
        }

        composable(Routes.MY_ORDERS_PAGE) {
            MyOrdersScreen(navController)
        }
        composable(Routes.ORDER_DETAILS_PAGE) {
            OrderDetailsScreen(navController)
        }
        composable(Routes.SETTING_SCREEN) {
            SettingScreen(navController)
        }
        composable(Routes.MY_PROFILE_DETAIL_SCREEN) {
            ProfileScreen(navController,{},{},{})
        }
        composable(Routes.SHIPPING_ADDRESS_SCREEN) {
            ShippingAddressesScreen(navController,addresses = dummyAddresses,{},{navController.navigate(Routes.ADD_SHIPPING_ADDRESS_SCREEN)})
        }
        composable(Routes.ADD_SHIPPING_ADDRESS_SCREEN) {
            AddShippingAddressScreen(navController) {navController.navigate(Routes.SHIPPING_ADDRESS_SCREEN)}
        }
    }
}

