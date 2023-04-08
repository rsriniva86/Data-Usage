package com.demo.datausage.common.logging.di

import com.demo.datausage.common.logging.EventLogReceiver_Impl
import org.koin.dsl.module

val logModule = module {
    single{
        EventLogReceiver_Impl(get())
    }
}