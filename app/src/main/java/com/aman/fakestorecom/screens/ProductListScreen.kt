package com.aman.fakestorecom.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberImagePainter
import com.aman.fakestorecom.models.ProductListItem
import com.aman.fakestorecom.navigation.Routes
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.viewmodels.CategoryViewModel
import com.aman.fakestorecom.viewmodels.ProductViewModel
import kotlinx.coroutines.flow.forEach

@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductViewModel = hiltViewModel()
) {
    PageBluePrint(title = "Products", rightIcon = Icons.Default.Search) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(16.dp))
            DisplayCategory(
                onCategorySelected = { category ->
                    if (category != null) {
                        viewModel.fetchProductsByCategory(category)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Collect the product list state
            val products = viewModel.products.collectAsState().value

            // Display the products in a 2-column grid
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                items(products.size) { index ->
                    ProductCard(
                        product = products[index],
                        onProductClick = {navController.navigate(Routes.productDetailScreenRoute(products[index].id))}
                    )
                }
            }
        }
    }

}

@Composable
fun ProductCard(product: ProductListItem,onProductClick:() -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .clickable { onProductClick() },
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(5.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ){
            // Load the product image
            Image(
                painter = rememberAsyncImagePainter(product.image),
                contentDescription = product.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Display product details (category, title, description, price)
            Text(
                text = product.category.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )

            Text(
                text = product.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )

            Text(
                text = product.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Price: $ ${product.price}",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayCategory(
    onCategorySelected: (String?) -> Unit,  // Lambda to pass the selected category back to the parent
    viewModel: CategoryViewModel = hiltViewModel()
) {
    val categories by viewModel.categories.collectAsState()
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    // Using a Box to handle dropdown expansion properly within LazyColumn or LazyGrid
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selectedCategory ?: "Select Category",
                onValueChange = {},
                readOnly = true,
                label = { Text("Category") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                modifier = Modifier
                    .menuAnchor()  // Ensure the dropdown appears aligned to the TextField
                    .fillMaxWidth()
                    .clickable { expanded = true }
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                // Add the "Any" option first
                DropdownMenuItem(
                    onClick = {
                        selectedCategory = "Any"
                        expanded = false
                        onCategorySelected(null)  // Pass null when "Any" is selected to trigger getProducts()
                    },
                    text = { Text(text = "Any", color = MaterialTheme.colorScheme.onSurface) }
                )

                // Then show the categories from API
                categories.forEach { category ->
                    DropdownMenuItem(
                        onClick = {
                            selectedCategory = category
                            expanded = false
                            onCategorySelected(category)  // Pass the selected category
                        },
                        text = {
                            Text(text = category, color = MaterialTheme.colorScheme.onSurface)
                        }
                    )
                }
            }
        }
    }
}
