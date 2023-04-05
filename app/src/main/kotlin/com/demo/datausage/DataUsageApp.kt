package com.demo.datausage

import android.app.Application
import android.content.Context

class DataUsageApp : Application() {
    init {
        instance = requireNotNull(this)
    }

    companion object {
        private lateinit var instance: DataUsageApp

        fun applicationContext(): Context {
            return instance
        }
    }
}