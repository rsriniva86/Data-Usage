package com.demo.datausage.core.repository.datausage

import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import com.demo.datausage.core.data.datasource.remote.DataUsageAPI
import com.demo.datausage.core.repository.SampleData.sampleDataUsageResponse
import com.demo.datausage.core.repository.SampleData.sampleMobileDataUsageDBData
import com.demo.datausage.core.repository.connection.ConnectionManager
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class DataUsageRepositoryTest {

    private lateinit var repository: DataUsageRepository

    @Mock
    private lateinit var dao: DataUsageDao

    @Mock
    private lateinit var service: DataUsageAPI

    @Mock
    private lateinit var connectionManager: ConnectionManager

    private val resource_id = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"

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


    @Test
    fun testGetYearWiseData_CacheDataChecks() {
        runBlocking {

            val myDataFlow = flow {
                emit(sampleMobileDataUsageDBData)
            }
            whenever(dao.fetchAllData()).thenReturn(myDataFlow)
            val dataReturned = repository.getYearWiseData().first()
            verify(dao, times(numInvocations = 1)).fetchAllData()
            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, dataReturned[0].year)
            var totalValue = 0.0
            sampleMobileDataUsageDBData
                .filter { it.year == 2011L }
                .forEach {

                    totalValue += it.value
                }
            Assert.assertEquals(
                totalValue.toString(),
                dataReturned[0].value
            )

        }
    }

    @Test
    fun testGetYearWiseData_ServerDataChecks() {
        runBlocking {

            val myDataFlow = flow {
                emit(sampleMobileDataUsageDBData)
            }
            whenever(dao.fetchAllData()).thenReturn(myDataFlow)
            whenever(connectionManager.isNetworkAvailable()).thenReturn(true)
            whenever(service.getDataUsage(resource_id)).thenReturn(sampleDataUsageResponse)
            val dataReturned = repository
                .getYearWiseData()
                .take(2)
                .toList()
            val cacheData = dataReturned[0]
            val serverData = dataReturned[1]
            verify(dao, times(numInvocations = 1)).fetchAllData()
            verify(dao, times(numInvocations = 1)).deleteAll()
            verify(dao, times(numInvocations = 1)).insertAll(any())

            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, cacheData[0].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[4].year, cacheData[1].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, serverData[0].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[4].year, cacheData[1].year)

            var totalValue = 0.0
            sampleMobileDataUsageDBData
                .filter { it.year == 2011L }
                .forEach {
                    totalValue += it.value
                }
            Assert.assertEquals(
                totalValue.toString(),
                cacheData[0].value
            )
            Assert.assertEquals(
                totalValue.toString(),
                serverData[0].value
            )
            totalValue = 0.0
            sampleMobileDataUsageDBData
                .filter { it.year == 2012L }
                .forEach {
                    totalValue += it.value
                }
            Assert.assertEquals(
                totalValue.toString(),
                cacheData[1].value
            )
            Assert.assertEquals(
                totalValue.toString(),
                serverData[1].value
            )
        }
    }

    @Test
    fun testGetQuarterWiseData_CacheDataChecks() {
        runBlocking {

            val myDataFlow = flow {
                emit(sampleMobileDataUsageDBData)
            }
            var totalValue = 0.0
            sampleMobileDataUsageDBData.forEach {
                totalValue += it.value
            }
            whenever(dao.fetchAllData()).thenReturn(myDataFlow)
            val dataReturned = repository.getQtrWiseData().first()
            verify(dao, times(numInvocations = 1)).fetchAllData()
            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, dataReturned[0].year)

            Assert.assertEquals(
                sampleMobileDataUsageDBData[0].value.toString(),
                dataReturned[0].qOneValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[1].value.toString(),
                dataReturned[0].qTwoValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[2].value.toString(),
                dataReturned[0].qThreeValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[3].value.toString(),
                dataReturned[0].qFourValue
            )
        }
    }

    @Test
    fun testGetQuarterWiseData_ServerDataChecks() {
        runBlocking {

            val myDataFlow = flow {
                emit(sampleMobileDataUsageDBData)
            }
            whenever(dao.fetchAllData()).thenReturn(myDataFlow)
            whenever(connectionManager.isNetworkAvailable()).thenReturn(true)
            whenever(service.getDataUsage(resource_id)).thenReturn(sampleDataUsageResponse)
            val dataReturned = repository
                .getQtrWiseData()
                .take(2)
                .toList()
            val cacheData = dataReturned[0]
            val serverData = dataReturned[1]
            verify(dao, times(numInvocations = 1)).fetchAllData()
            verify(dao, times(numInvocations = 1)).deleteAll()
            verify(dao, times(numInvocations = 1)).insertAll(any())

            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, cacheData[0].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[4].year, cacheData[1].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[0].year, serverData[0].year)
            Assert.assertEquals(sampleMobileDataUsageDBData[4].year, cacheData[1].year)


            Assert.assertEquals(
                sampleMobileDataUsageDBData[0].value.toString(),
                cacheData[0].qOneValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[1].value.toString(),
                cacheData[0].qTwoValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[2].value.toString(),
                cacheData[0].qThreeValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[3].value.toString(),
                cacheData[0].qFourValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[0].value.toString(),
                serverData[0].qOneValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[1].value.toString(),
                serverData[0].qTwoValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[2].value.toString(),
                serverData[0].qThreeValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[3].value.toString(),
                serverData[0].qFourValue
            )

            Assert.assertEquals(
                sampleMobileDataUsageDBData[4].value.toString(),
                cacheData[1].qOneValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[5].value.toString(),
                cacheData[1].qTwoValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[6].value.toString(),
                cacheData[1].qThreeValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[7].value.toString(),
                cacheData[1].qFourValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[4].value.toString(),
                serverData[1].qOneValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[5].value.toString(),
                serverData[1].qTwoValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[6].value.toString(),
                serverData[1].qThreeValue
            )
            Assert.assertEquals(
                sampleMobileDataUsageDBData[7].value.toString(),
                serverData[1].qFourValue
            )


        }
    }


}