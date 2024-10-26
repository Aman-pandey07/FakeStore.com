package com.aman.fakestorecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.navigation.App
import com.aman.fakestorecom.screens.onboard.OnboardingScreen
import com.aman.fakestorecom.screens.onboard.OnboardingUtils
import com.aman.fakestorecom.ui.theme.FakeStorecomTheme
import com.aman.fakestorecom.viewmodels.authviewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy {OnboardingUtils(this)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        val authViewModel : AuthViewModel by viewModels()
        setContent {
            FakeStorecomTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    if (onboardingUtils.isOnboardingCompleted()){
                        App(authViewModel = authViewModel)
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
        OnboardingScreen {
            onboardingUtils.setOnboardingCompleted()
            scope.launch {
                setContent {
                    App(authViewModel = authViewModel)
                }
            }
        }
    }
}

