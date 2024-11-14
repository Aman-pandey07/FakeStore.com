package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.fakestorecom.FakeStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.jar.Attributes.Name

class AddressViewModel : ViewModel() {

    val addressDao = FakeStore.addressDatabase.getAddressDao()
    val addressList: LiveData<List<Address>> =addressDao.getAllAddress()

    fun addAddress(title:String,description:String){
        viewModelScope.launch(Dispatchers.IO) {
            addressDao.addAddress(address = Address(name = title, address = description))
        }

    }
    fun deleteAddress(id:Int){
        viewModelScope.launch(Dispatchers.IO) {
            addressDao.deleteAddress(id)
        }

    }

}