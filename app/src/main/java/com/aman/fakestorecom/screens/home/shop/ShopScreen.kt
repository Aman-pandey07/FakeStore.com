package com.aman.fakestorecom.screens.home.shop

//TODO implement every click item with different dummy data for every category list
//TODO the back button click is done and search button click is left because its main functionality has not been written
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aman.fakestorecom.R
import com.aman.fakestorecom.navigation.Routes
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton

data class CategoryItem(val name: String, val imageRes: Int)
data class ShopScreenListItem(val name:String, var onCatItemClick: () -> Unit)

val womenCategoriesListItem = listOf(
    ShopScreenListItem("Handbag") {},
    ShopScreenListItem("Dress") {},
    ShopScreenListItem("Scarf") {},
    ShopScreenListItem("Heels") {},
    ShopScreenListItem("Blouse") {},
    ShopScreenListItem("Earrings") {},
    ShopScreenListItem("Sandals") {},
    ShopScreenListItem("Skirt") {},
    ShopScreenListItem("Perfume") {},
)

val menCategoriesListItem = listOf(
    ShopScreenListItem("Watch"){},
    ShopScreenListItem("Sunglasses"){},
    ShopScreenListItem("Sweater"){},
    ShopScreenListItem("Shirt"){},
    ShopScreenListItem("Jeans"){},
    ShopScreenListItem("Cap"){},
    ShopScreenListItem("Shoes"){},
    ShopScreenListItem("Shorts"){},
    ShopScreenListItem("Jacket"){},
)

val kidsCategoriesListItem = listOf(
    ShopScreenListItem("T-Shirt"){},
    ShopScreenListItem("Toy Car"){},
    ShopScreenListItem("Jacket"){},
    ShopScreenListItem("Sneakers"){},
    ShopScreenListItem("Hat"){},
    ShopScreenListItem("Backpack"){},
    ShopScreenListItem("Shorts"){},
    ShopScreenListItem("Socks"){},
    ShopScreenListItem("Puzzle"){},
)

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
fun ShopContent(navController: NavController) {


    var selectedTab by remember { mutableStateOf(0) }
    val categories = when (selectedTab) {
        0 -> womenCategories
        1 -> menCategories
        2 -> kidsCategories
        else -> emptyList()
    }

    val categoriesListItem = when (selectedTab) {
        0 -> womenCategoriesListItem
        1 -> menCategoriesListItem
        2 -> kidsCategoriesListItem
        else -> emptyList()
    }




    PageBluePrint(
        title = "Categories",
        rightIcon = Icons.Default.Search,
        {navController.navigateUp()},
        {},
    ){


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
                    .clickable { navController.navigate(Routes.PRODUCT_LIST_SCREEN) }
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

            RedGeneralButton(onClick = { navController.navigate(Routes.PRODUCT_LIST_SCREEN) }, text = "VIEW ALL ITEMS")
            Text(
                text = "Choose Category",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp),
                fontWeight = FontWeight.Light
            )

            LazyColumn(
                modifier = Modifier.height(400.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categoriesListItem.size) { index ->
                    ClickableCategories(listItem = categoriesListItem[index])
                }
            }



//            ClickableCategories("Top") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Shirts & Blouses") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Cardigans & Sweaters") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Knitwear") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Blazers") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Outerwear") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Pants") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("jeans") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Shorts") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Skirts") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))
//            ClickableCategories("Dresses") {}
////            HorizontalDivider(modifier = Modifier.padding(20.dp))

        }
    }
}

@Composable
fun ClickableCategories(listItem: ShopScreenListItem) {
    Column(modifier = Modifier.padding(top = 10.dp)){
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
                .clickable { listItem.onCatItemClick }
        ){
            Text(
                text = listItem.name,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = null, modifier = Modifier.padding(end = 20.dp)
            )
        }
        HorizontalDivider(modifier = Modifier.padding(20.dp))
    }

}


@Composable
fun CategoryCard(category: CategoryItem) {
    Card(
        shape = RoundedCornerShape(10.dp),
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
                    .height(110.dp),
                contentDescription = category.name,
                contentScale = ContentScale.Crop,
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ShopContentPreview() {
    val navController = rememberNavController()
    ShopContent(navController )
}