package com.aman.fakestorecom.screens.home.shop

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.aman.fakestorecom.viewmodels.shoppageviewmodel.CategoryViewModel
import com.aman.fakestorecom.viewmodels.shoppageviewmodel.Item


//TODO here i want to implement database for all the category
@Composable
fun ShopCatListListScreen(
    navController: NavController,
    categoryName: String?,
    viewModel: CategoryViewModel = hiltViewModel()
) {
    LaunchedEffect(categoryName) {
        if (categoryName != null) {
            viewModel.setCurrentCategory(categoryName)
        }
    }

    val currentCategory by viewModel.currentCategory.collectAsState()

    Scaffold {
        currentCategory?.let { category ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(category.items) { item ->
                    ItemCard(item = item)
                }
            }
//            LazyColumn(modifier = Modifier
//                .padding(16.dp)
//                .padding(it)
//            ) {
//                items(category.items) { item ->
//                    ItemCard(item = item)
//                }
//            }
        } ?: Column {
            Spacer(modifier = Modifier.height(60.dp))
            Text("No Data found", style = MaterialTheme.typography.bodyLarge)
        }
    }



//    PageBluePrint(
//        title = categoryName.toString(),
//        rightIcon = Icons.Default.Search,
//        onBackIconClick = { navController.navigateUp() },
//        onRightIconClick = { /*TODO*/ }
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Spacer(modifier = Modifier.height(30.dp))
//            Text(
//                text = "Category Details",
//                style = MaterialTheme.typography.titleMedium,
//                modifier = Modifier.padding(bottom = 16.dp)
//            )
//
//            categoryName?.let {
//                Text(
//                    text = "Category: $it",
//                    style = MaterialTheme.typography.titleMedium
//                )
//            } ?: Text("Category not found")
//        }
//    }

}
@Composable
fun ItemCard(item: Item) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Load image using Coil or another image loader
            Image(
                painter = rememberImagePainter(item.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = item.name.uppercase(), style = MaterialTheme.typography.titleMedium)
            Text(text = "Type: ${item.type}", style = MaterialTheme.typography.bodyMedium)
            Text(text = item.description, style = MaterialTheme.typography.bodySmall)
            Text(text = "Price: ${item.price}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}