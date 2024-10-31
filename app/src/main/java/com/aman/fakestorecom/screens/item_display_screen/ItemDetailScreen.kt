package com.aman.fakestorecom.screens.item_display_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import androidx.compose.material3.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton
import com.aman.fakestorecom.screens.home.homeicon.ItemsDisplayRows
import com.aman.fakestorecom.screens.home.homeicon.Product
import com.aman.fakestorecom.screens.home.homeicon.TheRowComposable
import com.aman.fakestorecom.screens.home.homeicon.dummyProducts


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



@Composable
fun ItemDetailsScreen(navController: NavController,productId: Int) {
    val product = dummyProducts.find { it.id == productId }

    // Display content only if the product is found
    product?.let {
        PageBluePrint(title = "Product Details", rightIcon = Icons.Default.Share,{navController.navigateUp()},
            {}) {
            //Item Details Screen Content from here to bottom
            var selectedSize by remember { mutableStateOf("Size") }
            var selectedColor by remember { mutableStateOf("Black") }
            Column(
                modifier= Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.padding(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Image(
                        painter = painterResource(id = it.imageRes),
                        contentDescription = "Product Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                // Row for Size and Color dropdowns and favorite icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(modifier = Modifier.weight(1f)) {
                        // Dropdown for Size
                        DropdownMenuBox(
                            selectedValue = selectedSize,
                            label = "Size",
                            onValueChange = { selectedSize = it }
                        )

                        Spacer(modifier = Modifier.width(18.dp))

                        // Dropdown for Color
                        DropdownMenuBox(
                            selectedValue = selectedColor,
                            label = "Color",
                            onValueChange = { selectedColor = it }
                        )
                    }
                    // Favorite icon
                    IconButton(onClick = { /* Add to favorites logic */ }) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = Color.Gray
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Product title and price row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = it.brand,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                        Text(
                            text = it.name,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Star rating
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            StarRating(rating = it.rating.toDouble())
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "(${it.totalRatings})",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    // Product price
                    Text(
                        text = it.discountedPrice,
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Product description
                Text(
                    text = "This is a sample description for ${it.name}. It features ${it.brand} quality with a rating of ${it.rating} stars.",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                RedGeneralButton(onClick = { /*TODO*/ }, text = "ADD TO CART")
                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Shipping info",
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Nothing"
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                Row(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "Support",
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp)
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Nothing"
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                TheRowComposable(t1 = "New", t2 = "You can also like this")
                ItemsDisplayRows(products = dummyProducts,navController)

                // Additional items can be displayed here if needed
            }
        }
    } ?: run {
        // If the product is not found, display an error or fallback UI
        Text(text = "Product not found", color = Color.Red)
    }

//    PageBluePrint(title = "Short dress",rightIcon = Icons.Default.Share){
//        //Item Details Screen Content from here to bottom
//        var selectedSize by remember { mutableStateOf("Size") }
//        var selectedColor by remember { mutableStateOf("Black") }
//        Column(
//            modifier= Modifier
//                .fillMaxWidth()
//                .verticalScroll(rememberScrollState())
//        ) {
//            Spacer(modifier = Modifier.padding(16.dp))
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(10.dp)
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.imdetail1),
//                    contentDescription = "Fashion sale background",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }
//            // Row for Size and Color dropdowns and favorite icon
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp),
////                horizontalArrangement = Arrangement.Start,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Row (modifier = Modifier.weight(1f)){
//                    // Dropdown for Size
//                    DropdownMenuBox(
//                        selectedValue = selectedSize,
//                        label = "Size",
//                        onValueChange = { selectedSize = it }
//                    )
//
//                    Spacer(modifier = Modifier.width(18.dp))
//
//                    // Dropdown for Color
//                    DropdownMenuBox(
//                        selectedValue = selectedColor,
//                        label = "Color",
//                        onValueChange = { selectedColor = it }
//                    )
//                }
//                // Favorite icon
//                IconButton(onClick = { /* Add to favorites logic */ }) {
//                    Icon(
//                        imageVector = Icons.Default.FavoriteBorder,
//                        contentDescription = "Favorite",
//                        tint = Color.Gray
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Product title and price row
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 8.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Column {
//                    Text(
//                        text = "H&M",
//                        fontWeight = FontWeight.Bold,
//                        fontSize = 22.sp
//                    )
//                    Text(
//                        text = "Short black dress",
//                        fontSize = 14.sp,
//                        color = Color.Gray
//                    )
//
//                    Spacer(modifier = Modifier.height(4.dp))
//
//                    // Star rating
//                    Row(verticalAlignment = Alignment.CenterVertically) {
//                        StarRating(rating = 4.5)
//                        Spacer(modifier = Modifier.width(4.dp))
//                        Text(
//                            text = "(10)",
//                            fontSize = 12.sp,
//                            color = Color.Gray
//                        )
//                    }
//                }
//
//                // Product price
//                Text(
//                    text = "$19.99",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 22.sp
//                )
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // Product description
//            Text(
//                text = "Short dress in soft cotton jersey with decorative buttons down the front and a wide, frill-trimmed...",
//                fontSize = 14.sp,
//                color = Color.Gray,
//                modifier = Modifier.padding(horizontal = 8.dp)
//            )
//            Spacer(modifier = Modifier.height(8.dp))
//
//            RedGeneralButton(onClick = { /*TODO*/ }, text = "ADD TO CART")
//            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
//
//            Row(modifier = Modifier.padding(8.dp)) {
//                Text(text = "Shipping info", modifier = Modifier
//                    .weight(1f)
//                    .padding(horizontal = 8.dp))
//                IconButton(onClick = { /*TODO*/ }) {
//                    androidx.compose.material3.Icon(
//                        imageVector = Icons.Default.KeyboardArrowRight,
//                        contentDescription = "Nothing"
//                    )
//                }
//            }
//
//            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
//
//            Row(modifier = Modifier.padding(8.dp)) {
//                Text(text = "Support", modifier = Modifier
//                    .weight(1f)
//                    .padding(horizontal = 8.dp))
//                IconButton(onClick = { /*TODO*/ }) {
//                    Icon(
//                        imageVector = Icons.Default.KeyboardArrowRight,
//                        contentDescription = "Nothing"
//                    )
//                }
//            }
//
//            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))
//
//            TheRowComposable(t1 = "New", t2 = "You can also like this")
//
////            ItemsDisplayRows(products = dummyProducts)
//
//        }
//    }
}

@Composable
fun DropdownMenuBox(
    selectedValue: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        Button(
            onClick = { expanded = true },
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            modifier = Modifier
                .defaultMinSize(minHeight = 45.dp)
                .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
        ) {
            Text(text = selectedValue, color = Color.Black)
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = label) },
                onClick = {
                    onValueChange(label)
                    expanded = false
                }
            )
        }
    }
}

@Composable
fun StarRating(rating: Double) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        repeat(5) { index ->
            Icon(
                imageVector = Icons.Filled.Favorite, // Use star icon instead of favorite
                contentDescription = null,
                tint = if (index < rating) Color(0xFFFFD700) else Color.Gray // Gold color for stars
            )
        }
    }
}


//@Preview
//@Composable
//fun ItemDetailsScreenPreview() {
//    val navController = rememberNavController()
//    ItemDetailsScreen(navController)
//}