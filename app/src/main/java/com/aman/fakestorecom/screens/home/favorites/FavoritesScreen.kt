package com.aman.fakestorecom.screens.home.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
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
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun FavoriteContent() {
    PageBluePrint(title = "", rightIcon = Icons.Default.Search) {
        val filters = listOf("Summer", "T-Shirts", "Shirts")
        var selectedFilter by remember { mutableStateOf("T-Shirts") }
        var priceSort by remember { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Favorites",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
                filters.forEach { filter ->
                    Button(
                        onClick = { selectedFilter = filter },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = if (selectedFilter == filter) Color.Gray else Color.LightGray
                        )
                    ) {
                        Text(text = filter)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Filter and sort section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* Add filter functionality */ }) {
                    Text(text = "Filters")
                }
                Button(onClick = { priceSort = !priceSort }) {
                    Text(text = if (priceSort) "Price: lowest to high" else "Price: highest to low")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Product list
            LazyColumn {
                items(productList) { product ->
                    ProductCard(product = product)
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = product.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Color: ${product.color}, Size: ${product.size}",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "${product.price}$",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                // Rating
                RatingBar(rating = product.rating)
            }

            IconButton(onClick = { /* Add to favorite/remove logic */ }) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_save),
                    contentDescription = "Save",
                    tint = Color.Red
                )
            }
        }
    }
}

@Composable
fun RatingBar(rating: Int) {
    Row {
        repeat(5) {
            val starColor = if (it < rating) Color.Yellow else Color.Gray
            Icon(
                painter = painterResource(id = android.R.drawable.star_on),
                contentDescription = null,
                tint = starColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun FavoriteContentPreview() {
    FavoriteContent()
}

data class Product(
    val name: String,
    val color: String,
    val size: String,
    val price: Int,
    val imageUrl: String,
    val rating: Int
)

val productList = listOf(
    Product("LIME Shirt", "Blue", "L", 32, "https://via.placeholder.com/150", 4),
    Product("Mango Longsleeve Violeta", "Orange", "S", 46, "https://via.placeholder.com/150", 0),
    Product("Olivier Shirt", "Gray", "L", 25, "https://via.placeholder.com/150", 3),
    Product("Berries T-Shirt", "Black", "M", 35, "https://via.placeholder.com/150", 5)
)