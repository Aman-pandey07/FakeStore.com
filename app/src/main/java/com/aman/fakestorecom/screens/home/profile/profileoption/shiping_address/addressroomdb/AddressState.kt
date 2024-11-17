package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class AddressState(

    val address: List<Address> = emptyList(),
    val name: MutableState<String> = mutableStateOf(""),
    val addressLine: MutableState<String> = mutableStateOf("")

)