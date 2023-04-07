package com.demo.datausage.core.repository

import android.util.Log
import com.demo.datausage.core.data.datasource.remote.DataUsageAPI
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DataUsageRepository {

    fun getYearWiseData(): Flow<List<YearWiseData>>
    fun getQtrWiseData(): Flow<QuarterWiseData>

}

class DataUsageRepository_Impl(
    private val service : DataUsageAPI
) : DataUsageRepository{
    override fun getYearWiseData(): Flow<List<YearWiseData>> = flow{
        val resource_id = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
        val response=service.getDataUsage(resource_id)
        Log.d("DEMO","$response")
        emit(provideDummyYearWiseData())
    }

    override fun getQtrWiseData(): Flow<QuarterWiseData> = flow {
    }
}

private fun provideDummyYearWiseData(): List<YearWiseData> {

    val startYear = 2000
    val startValue = 100

    val list = mutableListOf<YearWiseData>()

    for (index in 1..22) {
        val value = startValue + index
        val year = startYear + index
        list.add(
            YearWiseData(
                year = year, dataType = Datatype.MOBILE_DATA_USAGE, value = "$value"
            )
        )
    }
    return list

}