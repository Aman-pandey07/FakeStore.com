package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val addressLine: String,
    val dateAdded: Long,
)