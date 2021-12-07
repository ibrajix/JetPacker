/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.storage

import kotlinx.coroutines.flow.Flow

interface DataStorage {

    fun getWalletBalance() : Flow<String>
    suspend fun setWalletBalance(balance: String)

}