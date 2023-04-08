package com.demo.datausage.core.repository

import android.util.Log
import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import com.demo.datausage.core.data.datasource.remote.DataUsageAPI
import com.demo.datausage.core.repository.mappers.DBDataMapper
import com.demo.datausage.core.repository.mappers.QuarterWiseDataMapper
import com.demo.datausage.core.repository.mappers.YearWiseDataMapper
import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.domainmodels.YearWiseData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

interface DataUsageRepository {

    fun getYearWiseData(): Flow<List<YearWiseData>>
    fun getQtrWiseData(): Flow<List<QuarterWiseData>>

}

class DataUsageRepository_Impl(
    private val service : DataUsageAPI,
    private val dataUsageDao:DataUsageDao
) : DataUsageRepository{
    private val resource_id = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
    override fun getYearWiseData(): Flow<List<YearWiseData>> = flow{

        val dbData = dataUsageDao
            .fetchAllData()
            .first()

        if(dbData.isNotEmpty()) {
            emit(YearWiseDataMapper.mapToYearWiseDataList(dbData))
        }
        val response=service.getDataUsage(resource_id)
        Log.d("DEMO","$response")
        val dbDataListFromResponse = DBDataMapper.mapFromResponse(response)
        if(dbDataListFromResponse.isNotEmpty()){
            dataUsageDao.deleteAll()
            dataUsageDao.insertAll(dbDataListFromResponse)
        }
        emit(YearWiseDataMapper.mapToYearWiseDataList(dbData))
    }

    override fun getQtrWiseData(): Flow<List<QuarterWiseData>> = flow {
        val dbData = dataUsageDao
            .fetchAllData()
            .first()

        if(dbData.isNotEmpty()) {
            emit(QuarterWiseDataMapper.mapToQuarterWiseDataList(dbData))
        }
        val response=service.getDataUsage(resource_id)
        Log.d("DEMO","$response")
        val dbDataListFromResponse = DBDataMapper.mapFromResponse(response)
        if(dbDataListFromResponse.isNotEmpty()){
            dataUsageDao.deleteAll()
            dataUsageDao.insertAll(dbDataListFromResponse)
        }
        emit(QuarterWiseDataMapper.mapToQuarterWiseDataList(dbData))

    }
}