package com.aman.fakestorecom.screens.home.profile.profileoption

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.home.favorites.Product
import com.aman.fakestorecom.screens.home.favorites.productList


@Composable
fun MyOrdersScreen(modifier: Modifier = Modifier) {
    PageBluePrint(title = "My Orders", rightIcon = Icons.Default.Search) {
        var selectedFilter by remember { mutableStateOf("Delivered") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Spacer(modifier = Modifier.height(45.dp))
            LazyRow(
                modifier = Modifier,
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(buttonList){ button ->
                    LazyButton(
                        buttonItem = button,
                        selectedFilter = selectedFilter,
                        onClick = { newFilter -> selectedFilter = newFilter}
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(30.dp))

            LazyColumn {
                items(OrderList) { order ->
                    ProductCard(order = order)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}


@Composable
fun ProductCard(order:Orders) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // Header - Order Number and Date
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text ="Order no: ${order.orderNumber}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = order.date,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Tracking Number and Order Info
            Text(
                text = "Tracking number: ${order.trackingNumber}",
                color = Color.Gray,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Quantity: ${order.quantity}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
                Text(
                    text = "Total Amount: ${order.totalAmount}\$",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Details Button and Delivery Status
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    onClick = { /* Handle details click */ },
                    border = BorderStroke(1.dp, Color.Black),
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.size(width = 100.dp, height = 40.dp)
                ) {
                    Text(text = "Details", color = Color.Black)
                }

                Text(
                    text = "Delivered",
                    color = Color.Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                )
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

@Composable
fun LazyButton(
    buttonItem: ButtonItem,
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

@Preview
@Composable
fun MyOrdersScreenPreview() {
    MyOrdersScreen()
}

data class ButtonItem(
    val name: String
)
val buttonList = listOf(
    ButtonItem("Delivered"),
    ButtonItem("Processing"),
    ButtonItem("Cancelled"),
    ButtonItem("In Transit"),
)

data class Orders(
    val orderNumber:Int,
    val date: String,
    val trackingNumber: String,
    val quantity: Int,
    val totalAmount: Int,
    )

val OrderList = listOf(
    Orders(1347034,"15-12-2019","IW125n4568",3,120),
    Orders(1347034,"15-12-2019","IW125n4568",5,112),
    Orders(1344687,"23-01-2018","IW125n2568",2,56),
    Orders(134246,"12-12-2018","IW125n7598",3,70),
    Orders(134158,"25-02-2018","IW125n4265",2,45),
)