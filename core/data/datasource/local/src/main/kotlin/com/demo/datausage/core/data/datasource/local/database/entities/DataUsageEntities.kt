package com.demo.datausage.core.data.datasource.local.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_data_usage")
data class MobileDataUsageDB(
    @PrimaryKey()
    @ColumnInfo(name = "_id")
    val id: Long,
    @ColumnInfo(name = "year")
    val year: Long,
    @ColumnInfo(name = "quarter")
    val quarter: String,
    @ColumnInfo(name = "value")
    val value: Double
)