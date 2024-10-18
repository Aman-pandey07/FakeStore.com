package com.aman.fakestorecom.screens.loginsignup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.aman.fakestorecom.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyForgetPasswordScreen(navController: NavHostController) {
    // Scaffold ensures we handle top and bottom navigation bars correctly
    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { /* Handle back action */ },
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                title = {
                    Text(
                        text = "Forget Password",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    )
                },
                modifier = Modifier.statusBarsPadding(), // Adds padding for status bar
            )
        },
        content = { paddingValues ->
            // Use padding values to handle insets like top and bottom navigation bars
            ForgetPasswordScreen(
                modifier = Modifier
                    .padding(paddingValues)
                    .navigationBarsPadding() // Adds padding for bottom navigation bar
                    .fillMaxSize() // Ensure content takes full space with correct padding
            )
        }
    )
}



@Composable
fun ForgetPasswordScreen(modifier: Modifier=Modifier) {

    //1st column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ){
//            // Top section with back button and title
//            IconButton(
//                onClick = { /* Handle back action */ },
//                modifier = Modifier.align(Alignment.Start)
//            ) {
//                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Text(
//                text = "Forget Password",
//                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
//                modifier = Modifier.align(Alignment.Start)
//            )
//        }

        Spacer(modifier = Modifier.height(24.dp))

        //Second column
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Email TextField
            var email by remember { mutableStateOf("") }

            Text(text = "Enter your email address and we will send you a link to reset your password")


            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                singleLine = true,
                trailingIcon = {
                    if (email.isNotEmpty()) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Valid email",
                            tint = Color.Red
                        )
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))


            // Login Button
            Button(
                onClick = { /* Handle login */ },
                colors = ButtonDefaults.buttonColors(Color.Red),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .height(56.dp)
            ) {
                Text("SEND", color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(24.dp))

        //third column
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Social Login Section
            Text(text = "Or login with social account", color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(25.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Google login button
                IconButton(onClick = { /* Handle Google login */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google login",
                        modifier = Modifier.size(48.dp),
                        tint = Color.Unspecified
                    )
                }

                // Facebook login button
                IconButton(onClick = { /* Handle Facebook login */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.facebook03),
                        contentDescription = "Facebook login",
                        modifier = Modifier.size(48.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun ForgetPasswordScreenPreview() {
//
//    MyForgetPasswordScreen()
//}
//
