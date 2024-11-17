package com.aman.fakestorecom.screens.home.profile.profileoption.shiping_address.addressroomdb

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AddressViewModel(
    private val dao: AddressDao
): ViewModel() {

    private val isSortedByDateAdded = MutableStateFlow(true)

    private var address =
        isSortedByDateAdded.flatMapLatest { sort ->
            if (sort) {
                dao.getAddressOrderedByDateAdded()
            } else {
                dao.getAddressOrderedByTitle()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())


    val _state = MutableStateFlow(AddressState())
    val state =
        combine(_state, isSortedByDateAdded, address) { state, isSortedByDateAdded, address ->
            state.copy(
                address = address
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), AddressState())


    fun onEvent(event: AddressEvent) {
        when (event) {
            is AddressEvent.DeleteAddress -> {
                viewModelScope.launch (Dispatchers.IO){
                    dao.deleteAddress(event.address)
                }
            }

            is AddressEvent.SaveAddress -> {
                val address = Address(
                    id =0 ,
                    name = state.value.name.value,
                    addressLine = state.value.addressLine.value,
                    dateAdded = System.currentTimeMillis()
                )

                viewModelScope.launch (Dispatchers.IO){
                    dao.upsertAddress(address)
                }

                _state.update {
                    it.copy(
                        name = mutableStateOf(""),
                        addressLine = mutableStateOf("")
                    )
                }

            }

            AddressEvent.SortAddress -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }
        }
    }



//    val addressDao = FakeStore.addressDatabase.getAddressDao()
//    val addressList: LiveData<List<Address>> =addressDao.getAllAddress()
//
//    fun addAddress(name: String, addressLine: String, city: String, state: String, zipCode: String, country: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            addressDao.addAddress(
//                Address(
//                    name = name,
//                    addressLine = addressLine,
//                    city = city,
//                    state = state,
//                    zipCode = zipCode,
//                    country = country
//                )
//            )
//        }
//    }
//    fun deleteAddress(id:Int){
//        viewModelScope.launch(Dispatchers.IO) {
//            addressDao.deleteAddress(id)
//        }
//
//    }

}