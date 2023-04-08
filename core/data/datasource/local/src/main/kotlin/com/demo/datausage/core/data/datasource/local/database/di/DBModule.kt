package com.demo.datausage.core.data.datasource.local.database.di

import android.content.Context
import androidx.room.Room
import com.demo.datausage.core.data.datasource.local.database.DataUsageDB
import org.koin.dsl.module


val dbModule = module {
    single {
        provideAppDatabase(get())
    }
    single {
        provideDataUsageDao(get())
    }
}

fun provideDataUsageDao(db:DataUsageDB) =
    db.dataUsageDao()

fun provideAppDatabase(context: Context): DataUsageDB {
    return Room.databaseBuilder(
        context,
        DataUsageDB::class.java,
        "DataUsage_DB"
    ).build()
}