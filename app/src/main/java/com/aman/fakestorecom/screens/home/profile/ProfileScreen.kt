package com.aman.fakestorecom.screens.home.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun ProfileContent() {
    PageBluePrint(title = "My Profile", rightIcon = Icons.Default.Search) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height(25.dp))
            // Profile Section
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(bottom=24.dp).fillMaxWidth()
            ){
            Image(
                painter = painterResource(id = R.drawable.mens_watch ), // Replace with image URL or resource
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(
                    text = "Matilda Brown",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "matildabrown@mail.com",
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }

            // Orders
            ProfileItem(
                title = "My orders",
                subtitle = "Already have 12 orders",
                {}
            )

            // Shipping Addresses
            ProfileItem(
                title = "Shipping addresses",
                subtitle = "3 addresses",{}
            )

            // Payment Methods
            ProfileItem(
                title = "Payment methods",
                subtitle = "Visa **34",{}
            )

            // Promocodes
            ProfileItem(
                title = "Promocodes",
                subtitle = "You have special promocodes",{}
            )

            // My Reviews
            ProfileItem(
                title = "My reviews",
                subtitle = "Reviews for 4 items",{}
            )

            // Settings
            ProfileItem(
                title = "Settings",
                subtitle = "Notifications, password",{}
            )
        }
    }
}

@Composable
fun ProfileItem(title: String, subtitle: String,onClick: () -> Unit ){
    Column {
        Row(
            modifier = Modifier
                .clickable { onClick()}
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp).weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = subtitle,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    overflow = TextOverflow.Ellipsis
                )

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }



}


@Preview
@Composable
fun ProfileContentPreview() {
    ProfileContent()
}