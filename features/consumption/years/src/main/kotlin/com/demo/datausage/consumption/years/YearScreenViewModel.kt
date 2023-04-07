package com.demo.datausage.consumption.years

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.demo.datausage.core.repository.DataUsageRepository
import com.demo.datausage.domainmodels.YearWiseData

class YearScreenViewModel (
    private val repository: DataUsageRepository
    ): ViewModel() {

     val list = mutableStateListOf<YearWiseData>()

    suspend fun getData(){
        repository
            .getYearWiseData()
            .collect{
                list.clear()
                list.addAll(it)
            }
    }
}