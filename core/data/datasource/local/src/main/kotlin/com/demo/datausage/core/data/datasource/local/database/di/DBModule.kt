package com.demo.datausage.core.data.datasource.local.database.di

import android.content.Context
import androidx.room.Room
import com.demo.datausage.core.data.datasource.local.database.RoomDB
import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import org.koin.dsl.module


val dbModule = module {
    single <RoomDB>{
        provideAppDatabase(get())
    }
    single <DataUsageDao>{
        provideDataUsageDao(get())
    }
}

fun provideDataUsageDao(db:RoomDB) =
    db.dataUsageDao()

fun provideAppDatabase(context: Context): RoomDB {
    return Room.databaseBuilder(
        context,
        RoomDB::class.java,
        "DataUsage_DB"
    ).build()
}