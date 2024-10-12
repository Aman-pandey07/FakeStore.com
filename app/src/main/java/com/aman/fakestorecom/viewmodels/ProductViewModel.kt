package com.aman.fakestorecom.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.fakestorecom.models.ProductListItem
import com.aman.fakestorecom.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository) : ViewModel(){

    val products : StateFlow<List<ProductListItem>>
        get() = productRepository.products

    init {
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}
