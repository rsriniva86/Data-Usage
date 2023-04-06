package com.demo.datausage

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DataUsageApp : Application() {
    init {
        instance = requireNotNull(this)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@DataUsageApp)
        }
    }

    companion object {
        private lateinit var instance: DataUsageApp

        fun applicationContext(): Context {
            return instance
        }
    }
}