package com.aman.fakestorecom.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(){
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Text(text = "FakeStore.App", color = Color.Black)
                },
                modifier = Modifier.background(Color.Black)
            )
        }
    ){
        Box(modifier = Modifier.padding(it)){
            CategoryDropBox()
        }


    }
}

@Composable
fun ProductItem(modifier: Modifier = Modifier) {
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryDropBox() {
    val categories = listOf("All", "Electronics", "Jewelry", "Men's Clothing", "Women's Clothing")
    var expanded by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf(categories[0]) }

    Row(
        modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = selectedCategory,
            onValueChange = { },
            readOnly = true,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = "DropDown",
                    modifier = Modifier.clickable { expanded = true }
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(200.dp)
        ) {
            categories.forEach { category ->
                DropdownMenuItem(
                    onClick = {
                        selectedCategory = category
                        expanded = false
                    },
                    text = { Text(text = category) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductListScreenPreview(){
    ProductListScreen()
}