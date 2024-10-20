package com.aman.fakestorecom.api

import com.aman.fakestorecom.models.ProductListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface FakeStoreAPI {

    @GET("products")
    suspend fun getAllItems(): Response<List<ProductListItem>>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @retrofit2.http.Path("category") category: String
    ): Response<List<ProductListItem>>

}