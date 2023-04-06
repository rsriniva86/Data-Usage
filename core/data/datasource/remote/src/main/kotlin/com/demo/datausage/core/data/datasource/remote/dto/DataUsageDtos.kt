package com.demo.datausage.core.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

data class DataUsageResponse(
    @SerializedName("success")
    val success:Boolean
)