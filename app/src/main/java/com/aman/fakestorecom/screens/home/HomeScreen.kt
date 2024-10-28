package com.aman.fakestorecom.screens.home


import android.app.Activity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.navigation.Routes
import com.aman.fakestorecom.screens.home.bag.BagScreenContent
import com.aman.fakestorecom.screens.home.favorites.FavoriteContent
import com.aman.fakestorecom.screens.home.homeicon.HomeContent
import com.aman.fakestorecom.screens.home.profile.ProfileContent
import com.aman.fakestorecom.screens.home.shop.ShopContent
import com.aman.fakestorecom.screens.loginsignup.ExitDialog
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthState
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthViewModel


data class BottomNavigationItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenLayout(navController: NavController,authViewModel: AuthViewModel) {

    val authState = authViewModel.authState.observeAsState()
    LaunchedEffect (authState.value) {
        when (authState.value){
            is AuthState.Unauthenticated -> navController.navigate (Routes.LOGIN_SCREEN)
            else-> Unit
        }
    }

    val bottomNavController = rememberNavController()
    val items = listOf(
        BottomNavigationItem(
            title = "Home",
            route = Routes.HOME_SCREEN,
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        BottomNavigationItem(
            title = "Shop",
            route = Routes.SHOP_SCREEN,
            selectedIcon = Icons.Filled.ShoppingCart,
            unselectedIcon = Icons.Outlined.ShoppingCart,
        ),
        BottomNavigationItem(
            title = "Bag",
            route = Routes.BAG_SCREEN,
            selectedIcon = Icons.Filled.Lock,
            unselectedIcon = Icons.Outlined.Lock,
        ),
        BottomNavigationItem(
            title = "Favorite",
            route = Routes.FAVORITE_SCREEN,
            selectedIcon = Icons.Filled.Favorite,
            unselectedIcon = Icons.Outlined.FavoriteBorder,
        ),
        BottomNavigationItem(
            title = "Profile",
            route = Routes.PROFILE_SCREEN,
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                // Navigate only within bottom bar items using `bottomNavController`
                                bottomNavController.navigate(item.route) {
                                    popUpTo(bottomNavController.graph.startDestinationId) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            label = {
                                Text(text = item.title)
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.selectedIcon
                                    } else item.unselectedIcon,
                                    contentDescription = item.title,
//                                    tint = Color.Red
                                )
                            },
                            colors = NavigationBarItemDefaults.colors(
                                selectedIconColor = Color.Red, // Selected icon color
                                unselectedIconColor = Color.Gray, // Unselected icon color
                                selectedTextColor = Color.Red, // Selected text color
                                unselectedTextColor = Color.Gray // Unselected text color
                            )
                        )
                    }
                }
            },
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = "FakeCommerce.com",
                            color = Color.Red // Set title color to red
                        )
                    },
                    modifier = Modifier.height(35.dp)
                )
            },
            content = { paddingValues->
                NavHost(
                    navController = bottomNavController,
                    startDestination = Routes.HOME_SCREEN,  // Set initial bottom bar destination
                    modifier = Modifier.padding(paddingValues)
                ) {
                    composable(Routes.HOME_SCREEN) {
                        HomeContent(navController) // Define HomeContent Composable
                    }
                    composable(Routes.SHOP_SCREEN) {
                        ShopContent() // Define ShopContent Composable
                    }
                    composable(Routes.BAG_SCREEN) {
                        BagScreenContent() // Define ShopContent Composable
                    }
                    composable(Routes.FAVORITE_SCREEN) {
                        FavoriteContent() // Define FavoriteContent Composable
                    }
                    composable(Routes.PROFILE_SCREEN) {
                        ProfileContent(authViewModel) // Define ProfileContent Composable
                    }
                }
            }
        )
    }
}







