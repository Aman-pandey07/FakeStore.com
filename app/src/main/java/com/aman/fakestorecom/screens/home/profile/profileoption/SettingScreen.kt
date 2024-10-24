package com.aman.fakestorecom.screens.home.profile.profileoption

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aman.fakestorecom.screens.common_composable.PageBluePrint

@Composable
fun SettingScreen(modifier: Modifier = Modifier) {
    PageBluePrint(title = "Setting", rightIcon = Icons.Default.Search) {
        Column(
            modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = "Personal Information",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Full Name Field
            var fullName by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                value = fullName,
                onValueChange = { fullName = it },
                label = { Text(text = "Full name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Date of Birth Field
            var dob by remember { mutableStateOf("12/12/1989") }
            OutlinedTextField(
                value = dob,
                onValueChange = { dob = it },
                label = { Text(text = "Date of Birth") },
                modifier = Modifier.fillMaxWidth(),
                readOnly = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Password Section
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Password",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                TextButton(onClick = { /* Handle password change */ }) {
                    Text(text = "Change")
                }
            }

            // Password Field
            var password by remember { mutableStateOf("************") }
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                readOnly = true
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Notifications Section
            Text(
                text = "Notifications",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Notification Toggles
            NotificationToggle(title = "Sales", isCheckedInitial = true)
            NotificationToggle(title = "New arrivals", isCheckedInitial = false)
            NotificationToggle(title = "Delivery status changes", isCheckedInitial = false)
        }
    }
}

@Composable
fun NotificationToggle(title: String, isCheckedInitial: Boolean) {
    var isChecked by remember { mutableStateOf(isCheckedInitial) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = title, fontSize = 16.sp)
        Switch(
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Green,
                uncheckedThumbColor = Color.Gray,
                checkedIconColor = Color.Gray
            )
        )
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    SettingScreen()
}