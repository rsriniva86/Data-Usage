package com.demo.datausage.core.repository.datausage

import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB
import com.demo.datausage.core.data.datasource.remote.DataUsageAPI
import com.demo.datausage.core.repository.connection.ConnectionManager
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

internal class DataUsageRepositoryTest {

    private lateinit var repository: DataUsageRepository_Impl

    @Mock
    private lateinit var dao: DataUsageDao

    @Mock
    private lateinit var service : DataUsageAPI

    @Mock
    private lateinit var connectionManager: ConnectionManager

    @Before
    fun setUp() {

        dao = mock()
        service = mock()
        connectionManager = mock()
        repository = DataUsageRepository_Impl(
            dataUsageDao = dao,
            service = service,
            connectionManager = connectionManager
        )

    }

    @After
    fun cleanUp() {
        runBlocking {
            dao.deleteAll()
        }
    }

    val dbDataList = listOf(
        MobileDataUsageDB(
            id =1,
            year=2011,
            quarter = "Q1",
            value=10.0
        ),
        MobileDataUsageDB(
            id =2,
            year=2011,
            quarter = "Q2",
            value=11.0
        ),
        MobileDataUsageDB(
            id =3,
            year=2011,
            quarter = "Q3",
            value=12.0
        ),
        MobileDataUsageDB(
            id =4,
            year=2011,
            quarter = "Q4",
            value=13.0
        ),


    )
    @Test
    fun testGetYearWiseData_CacheDataChecks() {
        runBlocking {

            val myDataFlow = flow {
                emit(dbDataList)
            }
            whenever(dao.fetchAllData()).thenReturn(myDataFlow)
            val dataReturned=repository.getYearWiseData().first()
            verify(dao, times(numInvocations = 1)).fetchAllData()
            Assert.assertEquals(dbDataList[0].year,dataReturned[0].year)
            var totalValue = 0.0
            dbDataList.forEach {
                totalValue += it.value
            }
            Assert.assertEquals(
                totalValue.toString(),
                dataReturned[0].value
            )

        }
    }


}