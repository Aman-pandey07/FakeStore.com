package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface AddressDao {
    @Upsert
    suspend fun upsertAddress(address:Address)

    @Delete()
    suspend fun deleteAddress(address: Address)

    @Query("SELECT * FROM address ORDER BY dateAdded")
    fun getAddressOrderedByDateAdded(): Flow<List<Address>>

    @Query("SELECT * FROM address ORDER BY name ASC")
    fun getAddressOrderedByTitle(): Flow<List<Address>>
}