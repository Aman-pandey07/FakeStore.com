package com.aman.fakestorecom

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aman.fakestorecom.api.FakeStoreAPI
import com.aman.fakestorecom.screens.DisplayCategory
import com.aman.fakestorecom.screens.ProductListScreen
import com.aman.fakestorecom.screens.loginsignup.LoginScreen
import com.aman.fakestorecom.screens.onboard.OnboardingScreen
import com.aman.fakestorecom.screens.onboard.OnboardingUtils
import com.aman.fakestorecom.ui.theme.FakeStorecomTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

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
                        LoginScreen()
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
                    LoginScreen()
                }
            }
        }


    }

}

