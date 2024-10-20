package com.aman.fakestorecom.screens.home.shop


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton

data class CategoryItem(val name: String, val imageRes: Int)

// List of categories
val womenCategories = listOf(
    CategoryItem("New", R.drawable.new_image),
    CategoryItem("Clothes", R.drawable.clothes_image),
    CategoryItem("Shoes", R.drawable.shoes_image),
    CategoryItem("Accessories", R.drawable.accessories_image)
)
val menCategories = listOf(
    CategoryItem("T-Shirts", R.drawable.mens_tshirt),
    CategoryItem("Jeans", R.drawable.mens_jeans),
    CategoryItem("Shoes", R.drawable.mens_shoes),
    CategoryItem("Watches", R.drawable.mens_watch)
)
val kidsCategories = listOf(
    CategoryItem("Toys", R.drawable.kids_toys),
    CategoryItem("Clothes", R.drawable.kids_cloths),
    CategoryItem("Shoes", R.drawable.kids_shoes),
    CategoryItem("Books", R.drawable.kids_books)
)



@Composable
fun ShopContent() {



    PageBluePrint(title = "Categories", rightIcon = Icons.Default.Search) {
        var selectedTab by remember { mutableStateOf(0) }
        val categories = when (selectedTab) {
            0 -> womenCategories
            1 -> menCategories
            2 -> kidsCategories
            else -> emptyList()
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.padding(16.dp))
            // Tab Row
            TabRow(
                selectedTabIndex = selectedTab,
                containerColor = Color.White,
                contentColor = Color.Red,
                modifier = Modifier.fillMaxWidth()
            ) {
                listOf("Women", "Men", "Kids").forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(text = title, color = Color.Black) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Slider banner
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 5.dp),
                colors = CardDefaults.cardColors(Color.Red),
//                backgroundColor = Color.Red,
                shape = RoundedCornerShape(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "SUMMER SALES",
                        color = Color.White,
                        style = TextStyle(fontSize = 24.sp)
                    )
                    Text(
                        text = "Up to 50% off",
                        color = Color.White,
                        style = TextStyle(fontSize = 16.sp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            LazyColumn(
                modifier = Modifier.height(400.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories.size) { index ->
                    CategoryCard(category = categories[index])
                }
            }

            RedGeneralButton(onClick = { /*TODO*/ }, text = "VIEW ALL ITEMS")
            Text(
                text = "Choose Category",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Light
            )
            ClickableCategories("Top") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Shirts & Blouses") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Cardigans & Sweaters") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Knitwear") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Blazers") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Outerwear") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Pants") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("jeans") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Shorts") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Skirts") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))
            ClickableCategories("Dresses") {}
            HorizontalDivider(modifier = Modifier.padding(20.dp))

        }
    }
}

@Composable
fun ClickableCategories(text:String ,onClick: () -> Unit = {}) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
            .clickable { onClick() }
    ){
        Text(
            text = text,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null, modifier = Modifier.padding(end = 20.dp)
        )
    }
}


@Composable
fun CategoryCard(category: CategoryItem) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
//                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = category.name,
                style = TextStyle(fontSize = 18.sp),
                color = Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, end = 8.dp)
            )
            Image(
                painter = painterResource(id = category.imageRes),
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,

            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ShopContentPreview() {
    ShopContent()
}