package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AddressDao {
    @Query("SELECT * FROM ADDRESS")
    fun getAllAddress(): LiveData<List<Address>>

    @Insert
    fun addAddress(address:Address)

    @Query("DELETE FROM Address WHERE id = :id")
    fun deleteAddress(id:Int)
}