package com.aman.fakestorecom.screens.home.profile.profileoption

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun NotificationScreen(navController: NavController) {
    PageBluePrint(
        title = "Notifications",
        rightIcon = Icons.Default.List,
        onBackIconClick = { navController.navigateUp()},
        onRightIconClick = { /*TODO*/ }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .background(MaterialTheme.colorScheme.background)
        ){
            Spacer(modifier = Modifier.height(30.dp))

            NotificationItems(title = "title 1 ", description = "description 1"){}
            Spacer(modifier = Modifier.padding(5.dp))
            NotificationItems(title = "title 2 ", description = "description 2"){}
            Spacer(modifier = Modifier.padding(5.dp))
            NotificationItems(title = "title 3 ", description = "description 13"){}
            Spacer(modifier = Modifier.padding(5.dp))
            NotificationItems(title = "title 4 ", description = "description 4"){}
            Spacer(modifier = Modifier.padding(5.dp))
            NotificationItems(title = "title 5 ", description = "description 5"){}
            Spacer(modifier = Modifier.padding(5.dp))


        }
    }
}

@Composable
fun NotificationItems(title: String, description: String, onNotificationClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }
            IconButton(onClick = { onNotificationClick() }) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notification Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationScreenPreview(modifier: Modifier = Modifier) {

}