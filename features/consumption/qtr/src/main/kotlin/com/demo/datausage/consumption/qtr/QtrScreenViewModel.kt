package com.demo.datausage.consumption.qtr

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.demo.datausage.domainmodels.QuarterWiseData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import timber.log.Timber

class QtrScreenViewModel(
    private val repository: DataUsageRepository
) : ViewModel() {
    val list = mutableStateListOf<QuarterWiseData>()
    val index = mutableStateOf(0)
    val currentYear = mutableStateOf(2004L)
    private fun getIndexOfYear(year: Long) = list.indexOfFirst {
        it.year == year
    }

    fun setCurrentYear(currentIndex: Int) {
        if (currentIndex >= 0 && currentIndex < list.size) {
            currentYear.value = list[currentIndex].year
            index.value = currentIndex
        }
    }

    fun getQuarterData() {
        viewModelScope.launch(Dispatchers.IO) {
            getData()
        }
    }

    private suspend fun getData() {

        repository
            .getQtrWiseData()
            .catch {
                Timber.e("Exception happened:${it.message}")
            }
            .collect {
                list.clear()
                list.addAll(it)
                val indexToMove = getIndexOfYear(currentYear.value)
                if (indexToMove != -1) {
                    index.value = indexToMove
                }
            }
    }


}