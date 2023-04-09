package com.demo.datausage.core.data.datasource.remote

import com.demo.datausage.core.data.datasource.remote.dto.DataUsageResponse
import com.google.gson.Gson
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class DataUsageAPITest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var apiService: DataUsageAPI

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
        mockWebServer.start(8080)
        apiService =
            Retrofit.Builder()
                .baseUrl(mockWebServer.url("/")).addConverterFactory(
                    GsonConverterFactory.create(
                        Gson()
                    )
                ).build()
                .create(DataUsageAPI::class.java)
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testGetDataUsageCall() {
        runBlocking {

            val response =
                MockResponse().setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(SampleData.sampleDataUsageResponse)
            mockWebServer.enqueue(response)
            val expectedResponse =
                Gson().fromJson(SampleData.sampleDataUsageResponse, DataUsageResponse::class.java)

            val result = apiService.getDataUsage(SampleData.resource_id)
            val actualRequest = mockWebServer.takeRequest()

            assert(actualRequest.path == SampleData.expectedPath)
            assertEquals(expectedResponse, result)
        }

    }
}