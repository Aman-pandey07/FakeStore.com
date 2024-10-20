package com.aman.fakestorecom.screens.home.bag

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

data class CartItem(
    val imageRes: Int,
    val name: String,
    val color: String,
    val size: String,
    val price: String
)

@Composable
fun BagScreenContent() {
    PageBluePrint(title = "My Cart", rightIcon = Icons.Default.Search) {
        val cartItems = listOf(
            CartItem(R.drawable.bag_image1, "Pullover", "Black", "L", "51$"),
            CartItem(R.drawable.bag_image2, "T-Shirt", "Gray", "L", "30$"),
            CartItem(R.drawable.bag_image3, "Sport Dress", "Black", "M", "43$")
        )
        var totalAmount = cartItems.sumOf { it.price.removeSuffix("$").toInt() }
        var promoCode by remember { mutableStateOf("") }
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                ){
            Spacer(modifier = Modifier.padding(25.dp))
            Text(
                text = "My Bag",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(cartItems) { item ->
                    CartItemRow(item = item)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            PromoCodeInput(promoCode) { newCode ->
                promoCode = newCode
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Total amount: ${totalAmount}$",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun CartItemRow(item: CartItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(item.imageRes),
            contentDescription = item.name,
            modifier = Modifier
                .size(64.dp)
                .padding(end = 16.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
            Text(text = item.name, fontWeight = FontWeight.Bold)
            Text(text = "Color: ${item.color}   Size: ${item.size}")
        }
        Spacer(modifier = Modifier.width(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Decrease quantity logic */ }) {
                Icon(Icons.Default.Clear, contentDescription = "Decrease")
            }
            Text(text = "1")
            IconButton(onClick = { /* Increase quantity logic */ }) {
                Icon(Icons.Default.Add, contentDescription = "Increase")
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Text(text = item.price, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PromoCodeInput(promoCode: String, onPromoCodeChange: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = promoCode,
            onValueChange = onPromoCodeChange,
            modifier = Modifier.weight(1f),
            placeholder = { Text(text = "Enter your promo code") }
        )
        Spacer(modifier = Modifier.width(8.dp))
        IconButton(onClick = { /* Apply promo code logic */ }) {
            Icon(Icons.Default.ArrowForward, contentDescription = "Apply Promo Code")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BagScreenContentPreview() {
    BagScreenContent()
}