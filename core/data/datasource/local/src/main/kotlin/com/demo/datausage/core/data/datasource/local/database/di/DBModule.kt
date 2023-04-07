package com.demo.datausage.core.data.datasource.local.database.di

import android.content.Context
import androidx.room.Room
import com.demo.datausage.core.data.datasource.local.database.RoomDB
import org.koin.dsl.module


val dbModule = module {
    single {
        provideAppDatabase(get())
    }
}


fun provideAppDatabase(context: Context): RoomDB {
    return Room.databaseBuilder(
        context,
        RoomDB::class.java,
        "DataUsage_DB"
    ).build()
}