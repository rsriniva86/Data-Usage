package com.demo.datausage.core.data.datasource.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB


@Database(
    entities = [
        MobileDataUsageDB::class
         ],
    version = 1,
    exportSchema = false
)

abstract class RoomDB : RoomDatabase() {

    abstract fun dataUsageDao(): DataUsageDao

}