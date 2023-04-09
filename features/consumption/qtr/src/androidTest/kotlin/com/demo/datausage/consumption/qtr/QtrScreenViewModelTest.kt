package com.demo.datausage.consumption.qtr

import com.demo.datausage.consumption.qtr.SampleData.sampleQuarterWiseDataList
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class QtrScreenViewModelTest {
    private lateinit var viewModel: QtrScreenViewModel

    @Mock
    private lateinit var repository: DataUsageRepository

    @Before
    fun setUp() {
        repository = mock()
        viewModel = QtrScreenViewModel(repository)
    }

    @After
    fun cleanUp() {
    }

    @Test
    fun testGetQtrData() {
        runBlocking {
            val myDataFlow = flow {
                emit(sampleQuarterWiseDataList)
            }
            whenever(repository.getQtrWiseData()).thenReturn(myDataFlow)
            val job = viewModel.getQuarterData()
            job.join()
            TestCase.assertEquals(sampleQuarterWiseDataList, viewModel.list.toList())
        }
    }

}