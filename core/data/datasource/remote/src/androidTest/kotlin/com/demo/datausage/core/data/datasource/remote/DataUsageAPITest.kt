package com.demo.datausage.core.data.datasource.remote

import android.util.Log
import com.demo.datausage.core.data.datasource.remote.SampleData.sampleDataUsageResponse
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
    private lateinit var apiService : DataUsageAPI
    private val resource_id = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"

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
    fun testGetDataUsageCall(){
        runBlocking {

            val response =
                MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(sampleDataUsageResponse)
            mockWebServer.enqueue(response)
            val expectedResponse = Gson().fromJson(sampleDataUsageResponse, DataUsageResponse::class.java)

            val result = apiService.getDataUsage(resource_id)
            val actualRequest = mockWebServer.takeRequest()
            Log.e("TEST",""+result)
            Log.e("TEST",""+actualRequest.path)

            assert(actualRequest.path == "/action/datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f")
            assertEquals(expectedResponse,result)
        }

    }
}