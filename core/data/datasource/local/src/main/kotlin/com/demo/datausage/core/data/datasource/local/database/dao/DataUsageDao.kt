package com.demo.datausage.core.data.datasource.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB
import kotlinx.coroutines.flow.Flow

@Dao
interface DataUsageDao {

    @Query("SELECT * from mobile_data_usage")
    fun fetchAllData(): Flow<List<MobileDataUsageDB>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(db: MobileDataUsageDB): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(db: List<MobileDataUsageDB>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(db: MobileDataUsageDB)

    @Query("DELETE from mobile_data_usage")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(db: MobileDataUsageDB)

}