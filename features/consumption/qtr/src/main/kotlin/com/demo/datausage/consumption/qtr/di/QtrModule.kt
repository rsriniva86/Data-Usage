package com.demo.datausage.consumption.qtr.di

import com.demo.datausage.consumption.qtr.QtrScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val quarterModule = module {
    viewModel {
        QtrScreenViewModel(get())
    }
}