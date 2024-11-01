package com.aman.fakestorecom.screens.home.shop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ShopCatListListScreen(navController: NavController,categoryName: String?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Category Details",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        categoryName?.let {
            Text(
                text = "Category: $it",
                style = MaterialTheme.typography.titleMedium
            )
        } ?: Text("Category not found")
    }
}