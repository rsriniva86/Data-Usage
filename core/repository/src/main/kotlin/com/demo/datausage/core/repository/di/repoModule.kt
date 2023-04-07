package com.demo.datausage.core.repository.di

import com.demo.datausage.core.repository.DataUsageRepository_Impl
import org.koin.dsl.module

val repoModule = module {
    single {
        DataUsageRepository_Impl(get())
    }
}