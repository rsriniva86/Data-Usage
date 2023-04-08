package com.demo.datausage

import android.app.Application
import android.content.Context
import com.demo.datausage.common.logging.EventLogReceiver
import com.demo.datausage.common.logging.di.logModule
import com.demo.datausage.consumption.qtr.di.quarterModule
import com.demo.datausage.consumption.years.di.yearsModule
import com.demo.datausage.core.data.datasource.local.database.di.dbModule
import com.demo.datausage.core.data.datasource.remote.di.networkModule
import com.demo.datausage.core.repository.di.repoModule
import com.demo.datausage.di.appModule
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class DataUsageApp : Application() {

    private val eventlog : EventLogReceiver by inject()
    init {
        instance = requireNotNull(this)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DataUsageApp)
            modules(
                listOf(
                    appModule,
                    logModule,
                    networkModule,
                    dbModule,
                    repoModule,
                    yearsModule,
                    quarterModule
                )
            )
            eventlog.register()

        }
    }

    companion object {
        private lateinit var instance: DataUsageApp

        fun applicationContext(): Context {
            return instance
        }
    }
}