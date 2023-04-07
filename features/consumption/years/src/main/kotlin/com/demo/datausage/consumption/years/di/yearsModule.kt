package com.demo.datausage.consumption.years.di

import com.demo.datausage.consumption.years.YearScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val yearsModule = module {
    viewModel {
        YearScreenViewModel(get())
    }
}