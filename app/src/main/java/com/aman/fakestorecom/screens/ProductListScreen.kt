package com.aman.fakestorecom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.aman.fakestorecom.models.ProductListItem
import com.aman.fakestorecom.viewmodels.ProductViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductViewModel = hiltViewModel() // Dependency injection using Hilt
) {
    // Collect the product list state
    val products = viewModel.products.collectAsState().value

    // Display the products in a 2-column grid
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index])
        }
    }
}

@Composable
fun ProductCard(product: ProductListItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp) // Set a fixed height for cards
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            // Load the product image
            Image(
                painter = rememberAsyncImagePainter(product.image),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display product details (category, title, description, price)
            Text(text = product.category, fontSize = 12.sp)
            Text(text = product.title, fontSize = 12.sp)
            Text(text = product.description, maxLines = 2, fontSize = 12.sp)
            Text(text = "Price: ${product.price}", fontSize = 12.sp)
        }
    }
}