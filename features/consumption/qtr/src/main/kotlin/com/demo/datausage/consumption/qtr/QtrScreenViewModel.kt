package com.demo.datausage.consumption.qtr

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.launch

class QtrScreenViewModel(
    private val repository: DataUsageRepository
): ViewModel()  {
    val list = mutableStateListOf<QuarterWiseData>()
    fun getQuarterData(){
        viewModelScope.launch {
            getData()
        }
    }

    private suspend fun getData(){

        repository
            .getQtrWiseData()
            .collect{
                list.clear()
                list.addAll(it)
            }
    }
}