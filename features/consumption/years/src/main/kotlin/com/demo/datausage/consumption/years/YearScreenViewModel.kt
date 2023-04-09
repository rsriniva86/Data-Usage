package com.demo.datausage.consumption.years

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class YearScreenViewModel(
    private val repository: DataUsageRepository
) : ViewModel() {

    val list = mutableStateListOf<YearWiseData>()

    fun getYearData() : Job {
     val job= viewModelScope.launch(Dispatchers.IO) {
            getData()
        }
        return job
    }

    private suspend fun getData() {

        repository
            .getYearWiseData()
            .catch {
                Timber.e("Exception happened:${it.message}")
            }
            .collect {
                list.clear()
                list.addAll(it)
            }
    }
}