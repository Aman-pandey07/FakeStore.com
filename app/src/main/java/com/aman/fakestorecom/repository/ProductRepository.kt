package com.aman.fakestorecom.repository

import com.aman.fakestorecom.api.FakeStoreAPI
import com.aman.fakestorecom.models.ProductListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakeStoreAPI: FakeStoreAPI) {

    private val _products = MutableStateFlow<List<ProductListItem>>(emptyList())
    val products:StateFlow<List<ProductListItem>>
        get() = _products

    suspend fun getProducts(){
        val response = fakeStoreAPI.getAllItems()
        if (response.isSuccessful && response.body()!=null){
            //
            _products.emit(response.body()!!)
        }
    }

    suspend fun getProductsByCategory(category: String) {
        val response = fakeStoreAPI.getProductsByCategory(category)
        if (response.isSuccessful && response.body() != null) {
            _products.emit(response.body()!!)
        }
    }

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories:StateFlow<List<String>>
        get() = _categories

    suspend fun getCategories(){
        val response = fakeStoreAPI.getCategories()
        if (response.isSuccessful && response.body()!=null){
            //
            _categories.emit(response.body()!!)
        }
    }

}