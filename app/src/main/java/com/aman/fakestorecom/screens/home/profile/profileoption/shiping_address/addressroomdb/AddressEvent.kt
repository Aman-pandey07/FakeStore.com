package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

sealed interface AddressEvent {
    object SortAddress: AddressEvent

    data class DeleteAddress(val address: Address): AddressEvent

    data class SaveAddress(
        val name: String,
        val addressLine: String
    ): AddressEvent
}
