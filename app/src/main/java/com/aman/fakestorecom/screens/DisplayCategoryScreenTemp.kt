package com.aman.fakestorecom.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import com.aman.fakestorecom.viewmodels.CategoryViewModel


//@Composable
//fun DisplayCategory(
//    viewModel: CategoryViewModel = hiltViewModel()
//) {
//    val categories = viewModel.categories.collectAsState().value
//    var expanded by remember { mutableStateOf(false) }
//    var selectedCategory by remember { mutableStateOf<String?>(null) }
//    Column {
//        Spacer(modifier = Modifier.padding(40.dp))
//        Text(text = selectedCategory?: "Select a Category",
//            modifier = Modifier
//                .fillMaxWidth()
//                .clickable { expanded = true }
//                .padding(16.dp)
//        )
//        DropdownMenu(
//            expanded = expanded ,
//            onDismissRequest = { expanded = false }) {
//            categories.forEach{ category ->
//            DropdownMenuItem(
//                onClick = {
//                    selectedCategory = category
//                    expanded = false
//                },
//                text = {
//                    Text(
//                        text = category,
//                        color = Color.Black // Set the text color to black
//                    )
//                }
//            )
//            }
//
//        }
//
//    }
//
//}