package com.demo.datausage.core.repository.di

import com.demo.datausage.core.repository.DataUsageRepository
import com.demo.datausage.core.repository.DataUsageRepository_Impl
import org.koin.dsl.module

val repoModule = module {
    factory<DataUsageRepository> {
        DataUsageRepository_Impl(get())
    }
}