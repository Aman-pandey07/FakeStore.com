package com.aman.fakestorecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aman.fakestorecom.navigation.App
import com.aman.fakestorecom.screens.loginsignup.LoginScreen
import com.aman.fakestorecom.screens.onboard.OnboardingScreen
import com.aman.fakestorecom.screens.onboard.OnboardingUtils
import com.aman.fakestorecom.ui.theme.FakeStorecomTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy {OnboardingUtils(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {
            FakeStorecomTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    if (onboardingUtils.isOnboardingCompleted()){
                        App()
                    }else{
                        ShowOnboardingScreen()
                    }
                }
//                ProductListScreen()
//                DisplayCategory()
//                LoginScreen()
            }
        }
    }
    @Composable
    private fun ShowOnboardingScreen() {
        val scope = rememberCoroutineScope()
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    App()
                }
            }
        }
    }

}

