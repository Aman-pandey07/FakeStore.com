package com.aman.fakestorecom.screens.home.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun FavoriteContent() {
    PageBluePrint(title = "", rightIcon = Icons.Default.Search) {
        var selectedFilter by remember { mutableStateOf("T-Shirts") }
        var priceSort by remember { mutableStateOf(true) }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "Favorites",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(buttonList){button ->
                    LazyButton(
                        buttonItem = button,
                        selectedFilter = selectedFilter,
                        onClick = { newFilter -> selectedFilter = newFilter}
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Filter and sort section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Black)
                    Text(text = "Filters", color = Color.Black)
                }
                Button(onClick = { priceSort = !priceSort }, colors = ButtonDefaults.buttonColors(Color.White)) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null, tint = Color.Black)
                    Text(text = if (priceSort) "Price: lowest to high" else "Price: highest to low", color = Color.Black)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Product list
            LazyColumn {
                items(productList) { product ->
                    ProductCard(product = product)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }

        }
    }
}

@Composable
fun LazyButton(
    buttonItem:ButtonItem,
    selectedFilter: String,
    onClick: (String) -> Unit
) {
    Button(
        onClick = { onClick(buttonItem.name) },
        colors = ButtonDefaults.buttonColors(
            if (selectedFilter == buttonItem.name) Color.Black else Color.LightGray
        )
    ) {
        Text(text = buttonItem.name)
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = product.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = product.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Color: ${product.color}, Size: ${product.size}",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Text(
                    text = "${product.price}$",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                // Rating
                RatingBar(rating = product.rating)
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ){
                IconButton(onClick = { /* Add to favorite/remove logic */ }) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_close_clear_cancel),
                        contentDescription = "remove",
                        tint = Color.LightGray
                    )
                }
                IconButton(onClick = { /* Add to favorite/remove logic */ }) {
                    Icon(
                        painter = painterResource(id = android.R.drawable.ic_menu_save),
                        contentDescription = "Save",
                        tint = Color.Red
                    )
                }
            }
        }
    }
}

@Composable
fun RatingBar(rating: Int) {
    Row {
        repeat(5) {
            val starColor = if (it < rating) Color.Yellow else Color.Gray
            Icon(
                painter = painterResource(id = android.R.drawable.star_on),
                contentDescription = null,
                tint = starColor,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun FavoriteContentPreview() {
    FavoriteContent()
}

data class Product(
    val name: String,
    val color: String,
    val size: String,
    val price: Int,
    val imageUrl: Int,
    val rating: Int
)

val productList = listOf(
    Product("LIME Shirt", "Blue", "L", 32, R.drawable.img1, 4),
    Product("Mango Long-sleeve Violeta", "Orange", "S", 46, R.drawable.img2, 0),
    Product("Olivier Shirt", "Gray", "L", 25, R.drawable.img4, 3),
    Product("Berries T-Shirt", "Black", "M", 35, R.drawable.img1, 5),
    Product("Berries Shorts", "Black", "M", 35, R.drawable.img2, 5),
    Product("Denim Jackets", "Blue", "M", 35, R.drawable.img4, 5)
)

data class ButtonItem(
    val name: String
)


val buttonList = listOf(
    ButtonItem("All"),
    ButtonItem("T-Shirts"),
    ButtonItem("Shirts"),
    ButtonItem("pants"),
    ButtonItem("shorts"),
    ButtonItem("Jackets"),
    ButtonItem("Shoes"),
)