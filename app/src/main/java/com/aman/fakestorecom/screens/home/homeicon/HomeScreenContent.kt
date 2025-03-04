package com.aman.fakestorecom.screens.home.homeicon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.fakestorecom.R
import com.aman.fakestorecom.navigation.Routes

@Composable
fun HomeContent(navController: NavController) {
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
                    text = "Fashion\n\nsale",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )

                Spacer(modifier = Modifier.height(16.dp)) // Space between the text and the button

                // "Check" button
                Button(
                    onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) },
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
                TheRowComposable(
                    t1 = "New",
                    t2 = "You've never seen it before",
                    {navController.navigate(Routes.PRODUCT_LIST_SCREEN)}
                )
                ItemsDisplayRows(products = dummyProducts,navController)
                TheRowComposable(
                    t1 = "Sale",
                    t2 = "Supper summer sale",
                    {navController.navigate(Routes.PRODUCT_LIST_SCREEN)}
                )
                ItemsDisplayRows(products = dummyProducts,navController)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Row 1 (Full-width Image)
                ImageWithText(
                    imageRes = R.drawable.new_collection_image1, // Add your image resource here
                    text = "New collection",
                    onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) }
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Row 2 (Three Image Blocks)
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        ImageWithText(
                            imageRes = R.drawable.mens_hoodies_image, // Add your image resource
                            text = "Men’s hoodies",
                            onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) }
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ImageWithText(
                            imageRes = R.drawable.summer_sale_image, // Add your image resource
                            text = "Winter sale",
                            onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) },
                            textColor = Color.Blue // Text with red color for "Summer sale"
                        )

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        ImageWithText(
                            imageRes = R.drawable.summer_sale_image, // Add your image resource
                            text = "Summer sale",
                            onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) },
                            textColor = Color.Red // Text with red color for "Summer sale"
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        ImageWithText(
                            imageRes = R.drawable.black_image, // Add your image resource
                            text = "Black",
                            onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) }
                        )
                    }
                }
            }
        }

    }

}

@Composable
fun ImageWithText(
    imageRes: Int,
    text: String,
    onClick: () -> Unit,
    textColor: Color = Color.White // Default text color is white
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = text,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontFamily = FontFamily.Default
                ),
                textAlign = TextAlign.Start
            )
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
    val id: Int,
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
fun ItemsDisplayRows(products: List<Product>,navController: NavController) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductCard(
                product = products[index]
            ) { navController.navigate(Routes.itemDetailScreenRoute(products[index].id)) }
        }
    }
}
@Composable
fun ProductCard(product: Product,onProductClick:() -> Unit) {
    Card(
        modifier = Modifier
            .width(180.dp) // Width of each item
            .padding(vertical = 8.dp)
            .clickable { onProductClick() },
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 5.dp, vertical = 5.dp),
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
        id = 1,
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
        id = 2,
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
        id = 3,
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
        id = 4,
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
        id = 5,
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
        id = 6,
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
        id = 7,
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
        id = 8,
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
        id = 9,
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
        id = 10,
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
        id = 11,
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
        id = 12,
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


//@Preview(showBackground = true)
//@Composable
//fun HomeContentPreview(modifier: Modifier = Modifier) {
//    HomeContent()
//}