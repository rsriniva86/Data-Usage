package com.demo.datausage.core.data.datasource.remote

import com.demo.datausage.core.data.datasource.remote.dto.DataUsageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DataUsageAPI {
    @GET("action/datastore_search")
    suspend fun getDataUsage(@Query("resource_id")
                                 resource_id:String):DataUsageResponse

}