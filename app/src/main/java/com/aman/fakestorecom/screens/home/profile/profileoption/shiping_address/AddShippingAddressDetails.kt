package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressEvent
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressState



@Composable
fun AddShippingAddressScreen(
    state: AddressState,
    navController: NavController,
    onEvent: (AddressEvent) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {

                onEvent(AddressEvent.SaveAddress(
                    name = state.name.value,
                    addressLine = state.addressLine.value
                ))
                navController.popBackStack()
            })
            {

                Icon(
                    imageVector = Icons.Rounded.Check,
                    contentDescription = "Save Note"
                )

            }
        }
    ) { paddingValues ->
        PageBluePrint(
            title = "Add Address",
            rightIcon = Icons.Default.Check,
            onBackIconClick = { navController.navigateUp()},
            onRightIconClick = {
                onEvent(AddressEvent.SaveAddress(
                name = state.name.value,
                addressLine = state.addressLine.value
            ))
                navController.popBackStack()
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Please add the correct Name And Address Details",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = state.name.value,
                    onValueChange = {
                        state.name.value = it
                    },
                    textStyle = TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 17.sp
                    ),
                    placeholder = {
                        Text(text = "Full Name")
                    }

                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = state.addressLine.value,
                    onValueChange = {
                        state.addressLine.value = it
                    },
                    placeholder = {
                        Text(text = "Enter complete Address")
                    }

                )

            }
        }


    }

}







//@Composable
//fun AddShippingAddressScreen(
//    navController: NavController,
//    viewModel: AddressViewModel
//) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF3F4F6))
//            .padding(16.dp)
//    ) {
//        Spacer(modifier = Modifier.height(30.dp))
//        Text(
//            text = "Adding Shipping Address",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 16.dp)
//        )
//
//        val fullName = remember { mutableStateOf("") }
//        val addressLine = remember { mutableStateOf("") }
//        val city = remember { mutableStateOf("") }
//        val state = remember { mutableStateOf("") }
//        val zipCode = remember { mutableStateOf("") }
//        val country = remember { mutableStateOf("") }
//
//        TextField(
//            value = fullName.value,
//            onValueChange = { fullName.value = it },
//            label = { Text("Full name") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//        TextField(
//            value = addressLine.value,
//            onValueChange = { addressLine.value = it },
//            label = { Text("Address") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//        TextField(
//            value = city.value,
//            onValueChange = { city.value = it },
//            label = { Text("City") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//        TextField(
//            value = state.value,
//            onValueChange = { state.value = it },
//            label = { Text("State") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//        TextField(
//            value = zipCode.value,
//            onValueChange = { zipCode.value = it },
//            label = { Text("Zip Code") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//        TextField(
//            value = country.value,
//            onValueChange = { country.value = it },
//            label = { Text("Country") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp),
//            singleLine = true
//        )
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Button(
//            onClick = {
//                viewModel.addAddress(
//                    name = fullName.value,
//                    addressLine = addressLine.value,
//                    city = city.value,
//                    state = state.value,
//                    zipCode = zipCode.value,
//                    country = country.value
//                )
//                navController.popBackStack() // Go back to the previous screen
//            },
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(48.dp)
//                .background(Color.Red, shape = RoundedCornerShape(8.dp))
//        ) {
//            Text(
//                text = "SAVE ADDRESS",
//                color = Color.White,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
//}