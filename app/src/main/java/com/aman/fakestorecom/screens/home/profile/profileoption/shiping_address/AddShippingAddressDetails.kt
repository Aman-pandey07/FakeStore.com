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
        val city = remember { mutableStateOf("") }
        val state = remember { mutableStateOf("") }
        val zipCode = remember { mutableStateOf("") }
        val country = remember { mutableStateOf("United States") }

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
        TextField(
            value = city.value,
            onValueChange = { city.value = it },
            label = { Text("City") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )
        TextField(
            value = state.value,
            onValueChange = { state.value = it },
            label = { Text("State/Province/Region") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )
        TextField(
            value = zipCode.value,
            onValueChange = { zipCode.value = it },
            label = { Text("Zip Code (Postal Code)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true
        )
        TextField(
            value = country.value,
            onValueChange = {},
            label = { Text("Country") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            singleLine = true,
            enabled = false
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