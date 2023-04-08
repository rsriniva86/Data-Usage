package com.demo.datausage.core.repository.di


import com.demo.datausage.core.repository.connection.ConnectionManager
import com.demo.datausage.core.repository.connection.ConnectionManager_Impl
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.demo.datausage.core.repository.datausage.DataUsageRepository_Impl
import org.koin.dsl.module

val repoModule = module {
    factory<DataUsageRepository> {
        DataUsageRepository_Impl(get(),get(),get())
    }
    single<ConnectionManager>{
        ConnectionManager_Impl(get())
    }
}