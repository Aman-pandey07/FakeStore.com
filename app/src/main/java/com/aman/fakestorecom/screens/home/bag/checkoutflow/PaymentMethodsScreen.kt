package com.aman.fakestorecom.screens.home.bag.checkoutflow

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.aman.fakestorecom.R
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.common_composable.RedGeneralButton

@Composable
fun PaymentMethodsScreen(modifier: Modifier = Modifier) {
    PageBluePrint(title = "Payment Methods", rightIcon = Icons.Default.Lock) {
        var showDialog by remember { mutableStateOf(false) }
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { showDialog = true },
                    shape = CircleShape,
                    containerColor = FloatingActionButtonDefaults.containerColor
                ) {
                    Icon(Icons.Filled.Add, contentDescription = "Add Payment Method")
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(15.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(45.dp))
                Text("Your payment cards", style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(16.dp))

                SavedCard(R.drawable.card1,true)
                Spacer(modifier = Modifier.height(15.dp))
                SavedCard(R.drawable.card2,false)

                if (showDialog) {
                    AddCardDialog(onDismiss = { showDialog = false })
                }
            }
        }
    }
}


@Composable
fun SavedCard(card : Int, bolo:Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = card),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(280.dp),
                contentScale = ContentScale.FillBounds,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = bolo,
                    onCheckedChange = {false},
                    colors = CheckboxDefaults.colors(Color.Red)
                )
                Text(
                    text = "Use This as Default Payment method",
                    color = Color.Black,style = MaterialTheme.typography.titleMedium
                )
            }

        }

//        Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
//            Text(cardNumber, color = Color.White, style = MaterialTheme.typography.titleLarge)
//            Text(cardHolder, color = Color.White,style = MaterialTheme.typography.titleMedium)
//            Text(expiryDate, color = Color.White)
//        }
    }
}


@Composable
fun AddCardDialog(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Add new card", style = MaterialTheme.typography.titleMedium)

                Spacer(modifier = Modifier.height(16.dp))

                var cardNumber by remember { mutableStateOf("") }
                var expiryDate by remember { mutableStateOf("") }
                var cvv by remember { mutableStateOf("") }

                OutlinedTextField(
                    value = cardNumber,
                    onValueChange = { cardNumber = it },
                    label = { Text("Card number") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = expiryDate,
                    onValueChange = { expiryDate = it },
                    label = { Text("Expire Date") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = cvv,
                    onValueChange = { cvv = it },
                    label = { Text("CVV") },
                    visualTransformation = PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))
                RedGeneralButton(onClick = { /*TODO*/ }, text = "ADD CARD")

//                Row(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalArrangement = Arrangement.End
//                ) {
//                    Button(onClick = { onDismiss() }) {
//                        Text("Add Card")
//                    }
//                }
            }
        }
    }
}


@Preview
@Composable
fun PaymentMethodsScreenPreview() {
    PaymentMethodsScreen()
}