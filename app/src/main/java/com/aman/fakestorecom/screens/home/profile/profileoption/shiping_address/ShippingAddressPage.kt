package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.aman.fakestorecom.navigation.Routes
import com.aman.fakestorecom.screens.common_composable.PageBluePrint
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.Address
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressEvent
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressState
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressViewModel


@Composable
fun ShippingAddressesScreen(
    state: AddressState,
    navController: NavController,
    onEvent: (AddressEvent) -> Unit
) {
PageBluePrint(
    title = "Saved Addresses",
    rightIcon = Icons.Rounded.List,
    onBackIconClick = { navController.navigateUp() },
    onRightIconClick = { onEvent(AddressEvent.SortAddress) }
) {
    Column(){
        Spacer(modifier = Modifier.padding(25.dp))
//        Row(modifier = Modifier.fillMaxWidth()){
//            IconButton(onClick = { onEvent(AddressEvent.SortAddress) }) {
//                Icon(
//                    imageVector = Icons.Rounded.List,
//                    contentDescription = "Sort Notes",
//                    modifier = Modifier.size(35.dp),
//                    tint = MaterialTheme.colorScheme.onPrimary
//                )
//            }
//        }

        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    state.name.value = ""
                    state.addressLine.value = ""
                    navController.navigate(Routes.ADD_SHIPPING_ADDRESS_SCREEN)
                }) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add new note")
                }
            }
        ) { paddingValues ->

            LazyColumn(
                contentPadding = paddingValues,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.address.size) { index ->
                    AddressItem(
                        state = state,
                        index = index,
                        onEvent = onEvent
                    )
                }
            }
        }

    }

}


//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color(0xFFF3F4F6))
//            .padding(horizontal = 16.dp, vertical = 8.dp)
//    ) {
//        Spacer(modifier = Modifier.height(30.dp))
//        Text(
//            text = "Shipping Addresses",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 16.dp)
//        )
//        LazyColumn {
//            items(addresses.size) { index ->
//                AddressItem(
//                    address = addresses[index],
//                    onEditClick = { onEditClick(addresses[index]) }
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//            }
//        }
//        FloatingActionButton(
//            onClick = onAddNewAddressClick,
//            containerColor = MaterialTheme.colorScheme.primary,
//            modifier = Modifier
//                .align(Alignment.End)
//                .padding(16.dp)
//        ) {
//            Icon(Icons.Filled.Add, contentDescription = "Add Address", tint = Color.White)
//        }
//    }
}

@Composable
fun AddressItem(
    state: AddressState,
    index: Int,
    onEvent: (AddressEvent) -> Unit
) {
    val isChecked = remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = state.address[index].name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Edit",
                        color = Color.Red,
                        modifier = Modifier.clickable { }
                    )
                    IconButton(
                        onClick = {
                            onEvent(AddressEvent.DeleteAddress(state.address[index]))
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Delete,
                            contentDescription = "Delete Note",
                            modifier = Modifier.size(35.dp),
                            tint = MaterialTheme.colorScheme.onPrimaryContainer
                        )

                    }

                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = state.address[index].addressLine,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = isChecked.value,
                        onCheckedChange = { isChecked.value = it }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Use as the shipping address")
                }
            }

        }

    }
}