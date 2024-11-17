package com.aman.fakestorecom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.aman.fakestorecom.navigation.Routes
import com.aman.fakestorecom.screens.ProductDetailScreen
import com.aman.fakestorecom.screens.ProductListScreen
import com.aman.fakestorecom.screens.home.HomeScreenLayout
import com.aman.fakestorecom.screens.home.bag.checkoutflow.CheckoutPage
import com.aman.fakestorecom.screens.home.bag.checkoutflow.PaymentMethodsScreen
import com.aman.fakestorecom.screens.home.bag.checkoutflow.SuccessScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.MyOrdersScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.NotificationScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.OrderDetailsScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.ProfileScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.SettingScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.AddShippingAddressScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.ShippingAddressesScreen
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressDatabase
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressViewModel
import com.aman.fakestorecom.screens.home.shop.ShopCatListListScreen
import com.aman.fakestorecom.screens.item_display_screen.ItemDetailsScreen
import com.aman.fakestorecom.screens.loginsignup.MyForgetPasswordScreen
import com.aman.fakestorecom.screens.loginsignup.MyLoginScreen
import com.aman.fakestorecom.screens.loginsignup.MySignupScreen
import com.aman.fakestorecom.screens.onboard.OnboardingScreen
import com.aman.fakestorecom.screens.onboard.OnboardingUtils
import com.aman.fakestorecom.screens.searchscreen.SearchScreen
import com.aman.fakestorecom.ui.theme.FakeStorecomTheme
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val database by lazy {
        Room.databaseBuilder(
            applicationContext,
            AddressDatabase::class.java,
            "address.db"
        ).build()
    }

    private val viewModel by viewModels<AddressViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun<T: ViewModel> create(modelClass: Class<T>): T {
                    return AddressViewModel(database.dao) as T
                }
            }
        }
    )


    private val onboardingUtils by lazy {OnboardingUtils(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            FakeStorecomTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    val state by viewModel.state.collectAsState()
                    val navController = rememberNavController()
                    if (onboardingUtils.isOnboardingCompleted()){
                        //test starts
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
                                ShippingAddressesScreen(
                                    state = state,
                                    navController = navController,
                                    onEvent = viewModel::onEvent
                                )
                            }
                            composable(Routes.ADD_SHIPPING_ADDRESS_SCREEN) {
                                AddShippingAddressScreen(state = state,
                                    navController = navController,
                                    onEvent = viewModel::onEvent
                                )
                            }

                            composable(Routes.SEARCH_SCREEN) {
                                SearchScreen(navController)
                            }
                            composable(Routes.Notification_SCREEN) {
                                NotificationScreen(navController)
                            }
                        }
                        //test ends
                    }else{
                        ShowOnboardingScreen()
                    }
                }
            }
        }
    }
    @Composable
    private fun ShowOnboardingScreen() {
        val authViewModel : AuthViewModel by viewModels()
        val scope = rememberCoroutineScope()
        val navController = rememberNavController()
        val state by viewModel.state.collectAsState()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
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
                            ShippingAddressesScreen(
                                state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                        composable(Routes.ADD_SHIPPING_ADDRESS_SCREEN) {
                            AddShippingAddressScreen(state = state,
                                navController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }

                        composable(Routes.SEARCH_SCREEN) {
                            SearchScreen(navController)
                        }
                        composable(Routes.Notification_SCREEN) {
                            NotificationScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

