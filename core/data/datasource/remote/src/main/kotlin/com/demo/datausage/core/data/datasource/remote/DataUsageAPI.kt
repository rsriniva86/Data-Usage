package com.demo.datausage.core.data.datasource.remote

import retrofit2.http.GET

interface DataUsageAPI {

    @GET("action/datastore_search")
    suspend fun getDataUsage(resource_id:String)

}