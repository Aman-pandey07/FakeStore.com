package com.aman.fakestorecom.screens.home.profile.profileoption

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun OrderDetailsScreen() {
    PageBluePrint(title = "Order Details", rightIcon = Icons.Default.Search) {
        Column {
            Spacer(modifier = Modifier.height(45.dp))
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                item {
                    // Order Header
                    OrderHeader(
                        orderNumber = "№1947034",
                        date = "05-12-2019",
                        trackingNumber = "IW3475453455",
                        deliveryStatus = "Delivered"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Order Items
                    Text(
                        text = "3 items",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    // List of order items
                    OrderItem(
                        imageUrl = R.drawable.order_details_img_1,
                        title = "Pullover",
                        brand = "Mango",
                        color = "Gray",
                        size = "L",
                        price = "51$",
                        units = 1
                    )
                    OrderItem(
                        imageUrl = R.drawable.order_details_img_2,
                        title = "Pullover",
                        brand = "Mango",
                        color = "Gray",
                        size = "L",
                        price = "51$",
                        units = 1
                    )
                    OrderItem(
                        imageUrl = R.drawable.order_details_img_3,
                        title = "Pullover",
                        brand = "Mango",
                        color = "Gray",
                        size = "L",
                        price = "51$",
                        units = 1
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Order Information Section
                    OrderInformation(
                        shippingAddress = "3 Newbridge Court, Chino Hills, CA 91709, United States",
                        paymentMethod = "MasterCard ****3947",
                        deliveryMethod = "FedEx, 3 days, 15$",
                        discount = "10%, Personal promo code",
                        totalAmount = "133$"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Action Buttons
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        OutlinedButton(
                            onClick = { /* Reorder */ },
                            modifier = Modifier.size(width = 150.dp, height = 35.dp),
                            shape = RoundedCornerShape(50)
                        ) {
                            Text(text = "Reorder", color = Color.Black)
                        }

                        Button(
                            onClick = { /* Leave Feedback */ },
                            modifier = Modifier.size(width = 150.dp, height = 35.dp),
                            shape = RoundedCornerShape(50),
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text(text = "Leave feedback", color = Color.White)
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun OrderHeader(orderNumber: String, date: String, trackingNumber: String, deliveryStatus: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Order $orderNumber", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = date, fontSize = 14.sp, color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Tracking number: $trackingNumber",
                color = Color.Gray, fontSize = 14.sp
            )
            Text(
                text = deliveryStatus,
                color = Color.Green,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

    }
}

@Composable
fun OrderItem(
    imageUrl: Int,
    title: String,
    brand: String,
    color: String,
    size: String,
    price: String,
    units: Int
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imageUrl), // Replace with actual image URL
                contentDescription = title,
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = brand, fontSize = 14.sp, color = Color.Gray)
                Row {
                    Text(text = "Color: $color", fontSize = 14.sp, color = Color.Gray)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Size: $size", fontSize = 14.sp, color = Color.Gray)
                }
                Text(text = "Units: $units", fontSize = 14.sp, color = Color.Gray)
            }
            Text(text = price, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Composable
fun OrderInformation(shippingAddress: String, paymentMethod: String, deliveryMethod: String, discount: String, totalAmount: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(text = "Order information", fontWeight = FontWeight.Bold, fontSize = 16.sp)

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Shipping Address: $shippingAddress", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.mastercard_logo), // Replace with actual icon resource
                contentDescription = "Payment Method",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = paymentMethod, fontSize = 14.sp, color = Color.Gray)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Delivery method: $deliveryMethod", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Discount: $discount", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Total Amount: $totalAmount", fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun OrderDetailsScreenPreview() {
    OrderDetailsScreen()
}