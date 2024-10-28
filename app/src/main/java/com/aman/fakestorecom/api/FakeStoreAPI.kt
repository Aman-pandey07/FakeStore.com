package com.aman.fakestorecom.api

import com.aman.fakestorecom.models.ProductListItem
import com.aman.fakestorecom.screens.home.homeicon.Product
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FakeStoreAPI {

    @GET("products")
    suspend fun getAllItems(): Response<List<ProductListItem>>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @retrofit2.http.Path("category") category: String
    ): Response<List<ProductListItem>>


    @GET("products/{id}")  // This is the correct endpoint for getting a single product
    suspend fun getProductsById(@Path("id") id: Int): Response<ProductListItem>


}