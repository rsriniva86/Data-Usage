package com.demo.datausage.core.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class DataUsageResponse(
    @SerializedName("success")
    val success:Boolean,
    @SerializedName("result")
    val result:DataUsageResult?=null

)

data class DataUsageResult(
    @SerializedName("records")
    val records:List<DataUsageRecord>?=null
)

data class DataUsageRecord(
    @SerializedName("volume_of_mobile_data")
    val volume:Double,
    @SerializedName("quarter")
    val quarter:String,
    @SerializedName("_id")
    val id:Long
)