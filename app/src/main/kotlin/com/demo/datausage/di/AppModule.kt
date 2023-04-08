package com.demo.datausage.di

import android.content.Context
import com.demo.datausage.DataUsageApp
import org.koin.dsl.module


val appModule = module {
    single<Context> {
        DataUsageApp.applicationContext()
    }
}