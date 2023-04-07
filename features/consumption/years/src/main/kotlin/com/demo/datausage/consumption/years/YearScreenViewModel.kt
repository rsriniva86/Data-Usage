package com.demo.datausage.consumption.years

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.datausage.core.repository.DataUsageRepository
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.launch

class YearScreenViewModel (
    private val repository: DataUsageRepository
    ): ViewModel() {

     val list = mutableStateListOf<YearWiseData>()

    fun getYearData(){
        viewModelScope.launch {
            getData()
        }
    }

    private suspend fun getData(){

        repository
            .getYearWiseData()
            .collect{
                list.clear()
                list.addAll(it)
            }
    }
}