package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Address::class], version = 1, exportSchema = false)
abstract class AddressDatabase:RoomDatabase() {
    abstract val dao:AddressDao

}
