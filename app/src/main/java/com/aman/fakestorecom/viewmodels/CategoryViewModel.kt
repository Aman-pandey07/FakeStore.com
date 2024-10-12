package com.aman.fakestorecom.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.aman.fakestorecom.repository.ProductRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(private val productRepository: ProductRepository) :ViewModel() {
    val categories :StateFlow<List<String>>
        get() = productRepository.categories

    init {
        viewModelScope.launch {
            productRepository.getCategories()
        }
    }

}