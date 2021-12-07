/*
 * Written and Developed by Inuwa Ibrahim - https://linktr.ee/Ibrajix
*/

package com.ibrajix.jetpacker.di

import com.ibrajix.jetpacker.storage.DataStorage
import com.ibrajix.jetpacker.storage.DataStorageImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageModule {

    @Binds
    abstract fun bindDataStorage(dataStorageImplementation: DataStorageImplementation): DataStorage

}