package com.aman.fakestorecom.screens.home.profile.profileoption

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun ProfileScreen(
    navController: NavController,
    onEditClick: (String) -> Unit,
    onSupportClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
            .padding(horizontal = 16.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Picture
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Gray, shape = CircleShape)
        ) {
            AsyncImage(
                model = "https://example.com/profile.jpg", // Replace with your image URL
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.Center)
                    .clip(CircleShape)
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit Profile Picture",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.BottomEnd)
                    .background(Color.White, shape = CircleShape)
                    .padding(4.dp)
                    .clickable { onEditClick("profile picture") }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Name
        Text(
            text = "Nasir Uddin",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Profile Information
        ProfileInfoItem(
            icon = Icons.Default.Edit,
            label = "Nasir Uddin",
            onClick = { onEditClick("name") }
        )
        ProfileInfoItem(
            icon = Icons.Default.Email,
            label = "nasirahamed4488@gmail.com",
            onClick = { onEditClick("email") }
        )
        ProfileInfoItem(
            icon = Icons.Default.Lock,
            label = "********",
            onClick = { onEditClick("password") }
        )
        ProfileInfoItem(
            icon = Icons.Default.LocationOn,
            label = "Sirajganj, Bangladesh",
            onClick = { onEditClick("location") }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Support Option
        ProfileInfoItem(
            icon = Icons.Default.Warning,
            label = "Support",
            onClick = { onSupportClick() }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Logout Button
        ProfileInfoItem(
            icon = Icons.Default.ExitToApp,
            label = "Log Out",
            onClick = { onLogoutClick() }
        )
    }
}

@Composable
fun ProfileInfoItem(
    icon: ImageVector,
    label: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(Color.White, shape = MaterialTheme.shapes.medium)
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color.Black
        )
    }
}