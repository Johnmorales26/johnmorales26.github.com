package com.example.stores

import androidx.room.*

@Dao
interface StoreDao {
    @Query("SELECT * FROM StoreEntity")
    fun getAllStores() : MutableList<StoreEntity>

    @Insert
    fun addStore(storeEntity: StoreEntity): Long

    @Update
    fun updateStore(storeEntity: StoreEntity)

    @Delete
    fun deleteStore(storeEntity: StoreEntity)

    @Query("SELECT * FROM StoreEntity WHERE id = :id")
    fun getStoreById(id: Long): StoreEntity
}