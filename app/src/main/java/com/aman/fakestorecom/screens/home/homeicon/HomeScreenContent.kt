package com.aman.fakestorecom.screens.home.homeicon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.fakestorecom.R

@Composable
fun HomeContent() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .weight(0.7f)
        ) {
            // Background image
            Image(
                painter = painterResource(id = R.drawable.homescreen_sale_image),
                contentDescription = "Fashion sale background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // Content overlay with text and button
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom, // Align items to the bottom
                horizontalAlignment = Alignment.Start // Align text and button to the start (left)
            ) {
                // "Fashion sale" text
                Text(
                    text = "Fashion\nsale",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(16.dp)) // Space between the text and the button

                // "Check" button
                Button(
                    onClick = { /* Your onClick logic */ },
                    modifier = Modifier
                        .width(150.dp)
                        .clip(RoundedCornerShape(50.dp)), // Rounded corners
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
                ) {
                    Text(
                        text = "Check",
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
//                .weight(0.3f) // 40% height
                .background(Color.Transparent) // Empty space, no background
        ){
            Column(
                modifier = Modifier
                .fillMaxWidth()
            ){
                TheRowComposable(t1 = "New", t2 = "You've never seen it before",{/*handle view all click from here*/})
                ItemsDisplayRows(products = dummyProducts)
                TheRowComposable(t1 = "Sale", t2 = "Supper summer sale",{/*handle view all click from here*/})
                ItemsDisplayRows(products = dummyProducts)
            }
        }
    }

}

@Composable
fun TheRowComposable(t1:String,t2:String,onClick: () -> Unit = {}) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(0.7f)) {
            Text(
                text = t1,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
            Text(
                text = t2,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black,
                textAlign = TextAlign.Start
            )
        }
        Text(
            text = "View all",
            fontWeight = FontWeight.Light,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(0.3f)
                .clickable { onClick() },
        )
    }
}


data class Product(
    val imageRes: Int,
    val discount: String,
    val rating: Int,
    val totalRatings: Int,
    val brand: String,
    val name: String,
    val originalPrice: String,
    val discountedPrice: String
)
@Composable
fun ItemsDisplayRows(products: List<Product>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index])
        }
    }
}
@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .width(180.dp) // Width of each item
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp, vertical = 5.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Discount label
            Box {
                // Product Image
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = product.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                )
                Box(
                    modifier = Modifier
//                    .fillMaxWidth()
                        .background(Color.Red)
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                ) {
                    Text(text = product.discount, color = Color.White, fontSize = 12.sp)
                }

            }




            // Product details
            Column(
                modifier = Modifier.padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                // Rating and Favorite icon row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Display stars (simplified here with just a Text for stars and rating)
                    Text(text = "⭐ ${product.rating} (${product.totalRatings})", fontSize = 12.sp)

                    // Favorite Icon (outlined by default, filled when liked)
                    Icon(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.Gray
                    )
                }

                // Brand name
                Text(
                    text = product.brand,
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                // Product name
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                // Price details
                Row {
                    // Original Price
                    Text(
                        text = product.originalPrice,
                        style = MaterialTheme.typography.bodySmall.copy(
                            textDecoration = TextDecoration.LineThrough // Strikethrough
                        ),
                        color = Color.Gray,
                        modifier = Modifier.padding(4.dp)
                    )

                    // Discounted Price
                    Text(
                        text = product.discountedPrice,
                        fontSize = 14.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}



val dummyProducts = listOf(
    Product(
        imageRes = R.drawable.im1, // Replace with your sample image
        discount = "-20%",
        rating = 5,
        totalRatings = 10,
        brand = "Dorothy Perkins",
        name = "Evening Dress",
        originalPrice = "15$",
        discountedPrice = "12$"
    ),
    Product(
        imageRes = R.drawable.im2, // Replace with your sample image
        discount = "-15%",
        rating = 4,
        totalRatings = 8,
        brand = "Stilly",
        name = "Sport Dress",
        originalPrice = "22$",
        discountedPrice = "19$"
    ),
    Product(
        imageRes = R.drawable.im3, // Replace with your sample image
        discount = "-20%",
        rating = 5,
        totalRatings = 10,
        brand = "Dorothy Perkins",
        name = "Evening Dress",
        originalPrice = "15$",
        discountedPrice = "12$"
    ),
    Product(
        imageRes = R.drawable.im4, // Replace with your sample image
        discount = "-15%",
        rating = 4,
        totalRatings = 8,
        brand = "Stilly",
        name = "Sport Dress",
        originalPrice = "22$",
        discountedPrice = "19$"
    ),
    // More dummy products
    Product(
        imageRes = R.drawable.im5, // Replace with your sample image
        discount = "-10%",
        rating = 4,
        totalRatings = 14,
        brand = "Zara",
        name = "Summer Blouse",
        originalPrice = "35$",
        discountedPrice = "31$"
    ),
    Product(
        imageRes = R.drawable.im6, // Replace with your sample image
        discount = "-30%",
        rating = 5,
        totalRatings = 23,
        brand = "H&M",
        name = "Casual T-Shirt",
        originalPrice = "20$",
        discountedPrice = "14$"
    ),
    Product(
        imageRes = R.drawable.im7, // Replace with your sample image
        discount = "-50%",
        rating = 3,
        totalRatings = 45,
        brand = "Gucci",
        name = "Designer Handbag",
        originalPrice = "250$",
        discountedPrice = "125$"
    ),
    Product(
        imageRes = R.drawable.im8, // Replace with your sample image
        discount = "-25%",
        rating = 4,
        totalRatings = 30,
        brand = "Adidas",
        name = "Running Shoes",
        originalPrice = "90$",
        discountedPrice = "67$"
    ),
    Product(
        imageRes = R.drawable.im9, // Replace with your sample image
        discount = "-40%",
        rating = 5,
        totalRatings = 52,
        brand = "Nike",
        name = "Track Pants",
        originalPrice = "60$",
        discountedPrice = "36$"
    ),
    Product(
        imageRes = R.drawable.im10, // Replace with your sample image
        discount = "-35%",
        rating = 4,
        totalRatings = 28,
        brand = "Puma",
        name = "Gym Jacket",
        originalPrice = "80$",
        discountedPrice = "52$"
    ),
    Product(
        imageRes = R.drawable.im1, // Replace with your sample image
        discount = "-18%",
        rating = 3,
        totalRatings = 12,
        brand = "Levi's",
        name = "Denim Jeans",
        originalPrice = "50$",
        discountedPrice = "41$"
    ),
    Product(
        imageRes = R.drawable.im2, // Replace with your sample image
        discount = "-22%",
        rating = 4,
        totalRatings = 38,
        brand = "Mango",
        name = "Party Dress",
        originalPrice = "120$",
        discountedPrice = "94$"
    )
)


@Preview(showBackground = true)
@Composable
fun HomeContentPreview(modifier: Modifier = Modifier) {
    HomeContent()
}