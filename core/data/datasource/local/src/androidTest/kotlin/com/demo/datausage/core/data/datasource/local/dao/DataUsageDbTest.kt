package com.demo.datausage.core.data.datasource.local.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.demo.datausage.core.data.datasource.local.SampleData.sampleMobileDataUsageDBData
import com.demo.datausage.core.data.datasource.local.database.RoomDB
import com.demo.datausage.core.data.datasource.local.database.dao.DataUsageDao
import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class DataUsageDbTest {

    private lateinit var roomDB: RoomDB
    private lateinit var dao: DataUsageDao

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        roomDB = Room.inMemoryDatabaseBuilder(context, RoomDB::class.java).build()
        dao = roomDB.dataUsageDao()

    }

    @After
    fun onFinish() {
        roomDB.close()
    }

    @Test
    fun testFetchAll() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insert(sampleMobileDataUsageDBData[0])
            dao.insert(sampleMobileDataUsageDBData[1])
            var usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()

            assertEquals(2,usageData.size)
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[0]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[1]))
            assertFalse(usageData.contains(sampleMobileDataUsageDBData[2]))
            assertFalse(usageData.contains(sampleMobileDataUsageDBData[3]))

            dao.insert(sampleMobileDataUsageDBData[2])
            dao.insert(sampleMobileDataUsageDBData[3])
            usageData= dao.fetchAllData().first()

            assertEquals(4,usageData.size)
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[2]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[3]))


        }
    }

    @Test
    fun testInsert() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insert(sampleMobileDataUsageDBData[0])
            val usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[0]))
        }
    }

    @Test
    fun testInsertAll() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insertAll(sampleMobileDataUsageDBData)
            val usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(sampleMobileDataUsageDBData.size,usageData.size)
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[0]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[1]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[2]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[3]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[4]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[5]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[6]))
            assertTrue(usageData.contains(sampleMobileDataUsageDBData[7]))

        }
    }

    @Test
    fun testUpdate() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insert(sampleMobileDataUsageDBData[0])
            val usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(1,usageData.size)
            assertEquals(sampleMobileDataUsageDBData[0].value,usageData[0].value)
            val updatedData = MobileDataUsageDB(
                id = sampleMobileDataUsageDBData[0].id,
                year = sampleMobileDataUsageDBData[0].year,
                quarter = sampleMobileDataUsageDBData[0].quarter,
                value = 100.0
            )
            dao.update(updatedData)
            val updatedUsageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(1,updatedUsageData.size)
            assertNotEquals(sampleMobileDataUsageDBData[0].value,updatedUsageData[0].value)
            assertEquals(100.0,updatedUsageData[0].value)

        }
    }
    @Test
    fun testDeleteAll() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insertAll(sampleMobileDataUsageDBData)
            val usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(sampleMobileDataUsageDBData.size,usageData.size)
            dao.deleteAll()
            val data = dao.fetchAllData().first()
            assertTrue(data.isEmpty())
            assertEquals(0,data.size)
        }
    }

    @Test
    fun testDelete() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insertAll(sampleMobileDataUsageDBData)
            val usageData: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(sampleMobileDataUsageDBData.size,usageData.size)
            dao.delete(sampleMobileDataUsageDBData[0])
            val data = dao.fetchAllData().first()
            assertTrue(data.isNotEmpty())
            assertEquals((sampleMobileDataUsageDBData.size-1),data.size)
        }
    }



}