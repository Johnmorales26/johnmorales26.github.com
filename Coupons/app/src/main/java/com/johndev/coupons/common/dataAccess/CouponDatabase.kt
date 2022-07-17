package com.johndev.coupons.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.johndev.coupons.common.entities.CouponEntity

@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDatabase : RoomDatabase() {

    abstract fun couponDao(): CouponDao

}