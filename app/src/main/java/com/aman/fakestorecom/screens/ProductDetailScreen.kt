package com.aman.fakestorecom.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton
import com.aman.fakestorecom.screens.home.homeicon.ItemsDisplayRows
import com.aman.fakestorecom.screens.home.homeicon.TheRowComposable
import com.aman.fakestorecom.screens.home.homeicon.dummyProducts
import com.aman.fakestorecom.viewmodels.apiproduct.ProductViewModel

@Composable
fun ProductDetailScreen(
    navController: NavController,
    productId: Int,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    Log.d("ProductDetailScreen", "Received productId: $productId") // Log product ID
    // Fetch the product details when the screen is launched
    LaunchedEffect(productId) {
        viewModel.fetchProductById(productId)
    }

    // Collect product details state
    val specificProduct by viewModel.specificProduct.collectAsState()

    // UI layout for product details
    specificProduct?.let {
        PageBluePrint(
            title = "Product Details",
            rightIcon = Icons.Default.Share,
            {navController.navigateUp()},
            {/* TODO Search icon click implementation left*/}
        ){
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
                        painter = rememberAsyncImagePainter(it.image),
                        contentDescription = it.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()     // Set width to match the box width
                            .height(400.dp)     // Define a specific height
                            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
                    )
                }
                // Row for Size and Color dropdowns and favorite icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
//                horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row (modifier = Modifier.weight(1f)){
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

//                Spacer(modifier = Modifier.height(5.dp))

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
                            text = it.category,
                            fontSize = 14.sp,
                            color = Color.Gray
                        )
                        Text(
                            text = it.title,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Star rating
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            StarRating(rating = 4.5)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "(10)",
                                fontSize = 12.sp,
                                color = Color.Gray
                            )
                        }
                    }

                    // Product price
                    Text(
                        text = "$${it.price}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Product description
                Text(
                    text = it.description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))

                RedGeneralButton(onClick = { /*TODO*/ }, text = "ADD TO CART")
                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Shipping info", modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowRight,
                            contentDescription = "Nothing"
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

                Row(modifier = Modifier.padding(8.dp)) {
                    Text(text = "Support", modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp))
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

            }
        }
    } ?: Text(text = "Loading...", modifier = Modifier.padding(16.dp)) // Loading state
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
//    ProductDetailScreen(navController)
//}