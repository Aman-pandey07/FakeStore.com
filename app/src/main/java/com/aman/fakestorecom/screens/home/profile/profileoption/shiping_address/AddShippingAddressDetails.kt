package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AddShippingAddressScreen(navController: NavController,onSaveAddress: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Adding Shipping Address",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        val fullName = remember { mutableStateOf("") }
        val addressLine = remember { mutableStateOf("") }


        TextField(
            value = fullName.value,
            onValueChange = { fullName.value = it },
            label = { Text("Full name") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )
        TextField(
            value = addressLine.value,
            onValueChange = { addressLine.value = it },
            label = { Text("Address") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )


        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onSaveAddress,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(Color.Red, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                text = "SAVE ADDRESS",
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}