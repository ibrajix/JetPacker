/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ibrajix.jetpacker.storage.DataStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StorageViewModel @Inject constructor(private val dataStorage: DataStorage) : ViewModel()  {

    val walletBalance = dataStorage.getWalletBalance().asLiveData()
    fun changeWalletBalance(balance: String){
        viewModelScope.launch {
            dataStorage.setWalletBalance(balance)
        }
    }

}