package com.aman.fakestorecom.screens.home.bag.checkoutflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton

@Composable
fun CheckoutPage(navController: NavController) {
    PageBluePrint(title = "Checkout", rightIcon = Icons.Default.Notifications,{navController.navigateUp()},
        {}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            // Shipping Address
            Text("Shipping address", style = MaterialTheme.typography.titleMedium)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
//                backgroundColor = Color.White
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp).fillMaxWidth()
                ) {
                    Text("Jane Doe", fontWeight = FontWeight.Bold)
                    Text("3 Newbridge Court")
                    Text("Chino Hills, CA 91709, United States")
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Change", color = Color.Red)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Payment Method
            Text("Payment", style = MaterialTheme.typography.titleMedium)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mastercard_logo),
                            contentDescription = "Mastercard",
                            modifier = Modifier.size(60.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("**** **** **** 3947")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text("Change", color = Color.Red)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Delivery Method
            Text("Delivery method", style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                DeliveryMethodOption("FedEx", "2-3 days", R.drawable.fedex_logo)
                DeliveryMethodOption("USPS", "2-3 days", R.drawable.usps_logo)
                DeliveryMethodOption("DHL", "2-3 days", R.drawable.dhl_logo)
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Order Summary
            Column(
                modifier = Modifier.align(Alignment.End)
            ) {
                OrderSummaryItem(label = "Order:", amount = "112$")
                OrderSummaryItem(label = "Delivery:", amount = "15$")
                Divider(modifier = Modifier.padding(vertical = 8.dp))
                OrderSummaryItem(label = "Summary:", amount = "127$")
            }
            RedGeneralButton(onClick = { /*TODO*/ }, text = "SUBMIT ORDER")
        }
    }
}

@Composable
fun DeliveryMethodOption(name: String, duration: String, imageResId: Int) {
    Card(
        modifier = Modifier.size(100.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(8.dp).fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = name,
                modifier = Modifier.size(70.dp)
            )
            Text(duration, style = MaterialTheme.typography.labelSmall)
        }
    }
}

@Composable
fun OrderSummaryItem(label: String, amount: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.titleMedium, modifier = Modifier.weight(1f))
        Text(amount, style = MaterialTheme.typography.titleMedium)
    }
}
@Preview
@Composable
fun CheckoutPagePreview() {
    val navController = rememberNavController()
    CheckoutPage(navController)
}