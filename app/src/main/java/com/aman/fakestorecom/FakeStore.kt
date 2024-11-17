package com.aman.fakestorecom

import android.app.Application
import androidx.room.Room
import com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb.AddressDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FakeStore:Application() {
    companion object{
        lateinit var addressDatabase: AddressDatabase
    }

//    override fun onCreate() {
//        super.onCreate()
//        Room.databaseBuilder(
//            applicationContext,
//            AddressDatabase::class.java,
//            AddressDatabase.Name
//        ).build()
//    }

}