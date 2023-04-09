package com.demo.datausage.consumption.years

import com.demo.datausage.consumption.years.SampleData.sampleYearWiseData
import com.demo.datausage.core.repository.datausage.DataUsageRepository
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class YearScreenViewModelTest {

    private lateinit var viewModel: YearScreenViewModel

    @Mock
    private lateinit var repository: DataUsageRepository

    @Before
    fun setUp() {
        repository = mock()
        viewModel = YearScreenViewModel(repository)
    }

    @After
    fun cleanUp() {
    }

    @Test
    fun testGetYearData() {
        runBlocking {
            val myDataFlow = flow {
                emit(sampleYearWiseData)
            }
            whenever(repository.getYearWiseData()).thenReturn(myDataFlow)
            val job = viewModel.getYearData()
            job.join()
            assertEquals(sampleYearWiseData, viewModel.list.toList())
        }
    }


}