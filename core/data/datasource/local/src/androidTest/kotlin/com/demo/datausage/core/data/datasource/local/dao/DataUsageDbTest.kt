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
            var activities: List<MobileDataUsageDB> = dao.fetchAllData().first()

            assertEquals(2,activities.size)
            assertTrue(activities.contains(sampleMobileDataUsageDBData[0]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[1]))
            assertFalse(activities.contains(sampleMobileDataUsageDBData[2]))
            assertFalse(activities.contains(sampleMobileDataUsageDBData[3]))

            dao.insert(sampleMobileDataUsageDBData[2])
            dao.insert(sampleMobileDataUsageDBData[3])
            activities= dao.fetchAllData().first()

            assertEquals(4,activities.size)
            assertTrue(activities.contains(sampleMobileDataUsageDBData[2]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[3]))


        }
    }

    @Test
    fun testInsert() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insert(sampleMobileDataUsageDBData[0])
            val activities: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertTrue(activities.contains(sampleMobileDataUsageDBData[0]))
        }
    }

    @Test
    fun testInsertAll() {
        runBlocking {
            dao.deleteAll()
            assertTrue(dao.fetchAllData().first().isEmpty())
            dao.insertAll(sampleMobileDataUsageDBData)
            val activities: List<MobileDataUsageDB> = dao.fetchAllData().first()
            assertEquals(sampleMobileDataUsageDBData.size,activities.size)
            assertTrue(activities.contains(sampleMobileDataUsageDBData[0]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[1]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[2]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[3]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[4]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[5]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[6]))
            assertTrue(activities.contains(sampleMobileDataUsageDBData[7]))

        }
    }

}