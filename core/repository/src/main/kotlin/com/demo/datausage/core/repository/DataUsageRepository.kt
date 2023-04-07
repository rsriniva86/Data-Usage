package com.demo.datausage.core.repository

import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface DataUsageRepository {

    fun getYearWiseData(): Flow<YearWiseData>
    fun getQtrWiseData(): Flow<QuarterWiseData>

}

class DataUsageRepository_Impl : DataUsageRepository{
    override fun getYearWiseData(): Flow<YearWiseData> = flow{

    }

    override fun getQtrWiseData(): Flow<QuarterWiseData> = flow {
    }
}