package com.aman.fakestorecom.viewmodels.dummyproductviewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aman.fakestorecom.R
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


data class Product(
    val imageRes: Int,
    val discount: String,
    val rating: Int,
    val totalRatings: Int,
    val brand: String,
    val name: String,
    val originalPrice: String,
    val discountedPrice: String
)

@HiltViewModel
class DummyProductViewModel @Inject constructor() : ViewModel() {
    // List of products
    val productList = listOf(
        Product(
            imageRes = R.drawable.im1,
            discount = "-20%",
            rating = 5,
            totalRatings = 10,
            brand = "Dorothy Perkins",
            name = "Evening Dress",
            originalPrice = "15$",
            discountedPrice = "12$"
        ),
        Product(
            imageRes = R.drawable.im2, // Replace with your sample image
            discount = "-15%",
            rating = 4,
            totalRatings = 8,
            brand = "Stilly",
            name = "Sport Dress",
            originalPrice = "22$",
            discountedPrice = "19$"
        ),
        Product(
            imageRes = R.drawable.im3, // Replace with your sample image
            discount = "-20%",
            rating = 5,
            totalRatings = 10,
            brand = "Dorothy Perkins",
            name = "Evening Dress",
            originalPrice = "15$",
            discountedPrice = "12$"
        ),
        Product(
            imageRes = R.drawable.im4, // Replace with your sample image
            discount = "-15%",
            rating = 4,
            totalRatings = 8,
            brand = "Stilly",
            name = "Sport Dress",
            originalPrice = "22$",
            discountedPrice = "19$"
        ),
        // More dummy products
        Product(
            imageRes = R.drawable.im5, // Replace with your sample image
            discount = "-10%",
            rating = 4,
            totalRatings = 14,
            brand = "Zara",
            name = "Summer Blouse",
            originalPrice = "35$",
            discountedPrice = "31$"
        ),
        Product(
            imageRes = R.drawable.im6, // Replace with your sample image
            discount = "-30%",
            rating = 5,
            totalRatings = 23,
            brand = "H&M",
            name = "Casual T-Shirt",
            originalPrice = "20$",
            discountedPrice = "14$"
        ),
        Product(
            imageRes = R.drawable.im7, // Replace with your sample image
            discount = "-50%",
            rating = 3,
            totalRatings = 45,
            brand = "Gucci",
            name = "Designer Handbag",
            originalPrice = "250$",
            discountedPrice = "125$"
        ),
        Product(
            imageRes = R.drawable.im8, // Replace with your sample image
            discount = "-25%",
            rating = 4,
            totalRatings = 30,
            brand = "Adidas",
            name = "Running Shoes",
            originalPrice = "90$",
            discountedPrice = "67$"
        ),
        Product(
            imageRes = R.drawable.im9, // Replace with your sample image
            discount = "-40%",
            rating = 5,
            totalRatings = 52,
            brand = "Nike",
            name = "Track Pants",
            originalPrice = "60$",
            discountedPrice = "36$"
        ),
        Product(
            imageRes = R.drawable.im10, // Replace with your sample image
            discount = "-35%",
            rating = 4,
            totalRatings = 28,
            brand = "Puma",
            name = "Gym Jacket",
            originalPrice = "80$",
            discountedPrice = "52$"
        ),
        Product(
            imageRes = R.drawable.im1, // Replace with your sample image
            discount = "-18%",
            rating = 3,
            totalRatings = 12,
            brand = "Levi's",
            name = "Denim Jeans",
            originalPrice = "50$",
            discountedPrice = "41$"
        ),
        Product(
            imageRes = R.drawable.im2, // Replace with your sample image
            discount = "-22%",
            rating = 4,
            totalRatings = 38,
            brand = "Mango",
            name = "Party Dress",
            originalPrice = "120$",
            discountedPrice = "94$"
        )
    )

    // Selected product to be passed between screens
    private val _selectedProduct = MutableLiveData<Product>()
    val selectedProduct: LiveData<Product> = _selectedProduct

    fun selectProduct(product: Product) {
        _selectedProduct.value = product
    }
}