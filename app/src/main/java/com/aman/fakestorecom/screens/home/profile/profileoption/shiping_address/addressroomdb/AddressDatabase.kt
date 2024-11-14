package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Address::class], version = 1)
abstract class AddressDatabase:RoomDatabase() {

    companion object{
        const val Name = "Address_DB"
    }
    abstract fun getAddressDao(): AddressDao

}