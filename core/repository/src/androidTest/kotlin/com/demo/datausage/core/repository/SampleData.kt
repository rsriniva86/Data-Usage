package com.demo.datausage.core.repository

import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB
import com.demo.datausage.core.data.datasource.remote.dto.DataUsageRecord
import com.demo.datausage.core.data.datasource.remote.dto.DataUsageResponse
import com.demo.datausage.core.data.datasource.remote.dto.DataUsageResult

object SampleData {
    val sampleMobileDataUsageDBData = listOf(
        MobileDataUsageDB(
            id =1,
            year=2011,
            quarter = "Q1",
            value=10.0
        ),
        MobileDataUsageDB(
            id =2,
            year=2011,
            quarter = "Q2",
            value=11.0
        ),
        MobileDataUsageDB(
            id =3,
            year=2011,
            quarter = "Q3",
            value=12.0
        ),
        MobileDataUsageDB(
            id =4,
            year=2011,
            quarter = "Q4",
            value=13.0
        ),
        MobileDataUsageDB(
            id =5,
            year=2012,
            quarter = "Q1",
            value=11.0
        ),
        MobileDataUsageDB(
            id =6,
            year=2012,
            quarter = "Q2",
            value=11.0
        ),
        MobileDataUsageDB(
            id =7,
            year=2012,
            quarter = "Q3",
            value=12.0
        ),
        MobileDataUsageDB(
            id =8,
            year=2012,
            quarter = "Q4",
            value=13.0
        )
        )

    val sampleDataUsageResponse: DataUsageResponse = DataUsageResponse(
        success = true,
        result = DataUsageResult(
            records = listOf(
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[0].id,
                    volume = sampleMobileDataUsageDBData[0].value,
                    quarter = "${sampleMobileDataUsageDBData[0].year}-${sampleMobileDataUsageDBData[0].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[1].id,
                    volume = sampleMobileDataUsageDBData[1].value,
                    quarter = "${sampleMobileDataUsageDBData[1].year}-${sampleMobileDataUsageDBData[1].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[2].id,
                    volume = sampleMobileDataUsageDBData[2].value,
                    quarter = "${sampleMobileDataUsageDBData[2].year}-${sampleMobileDataUsageDBData[2].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[3].id,
                    volume = sampleMobileDataUsageDBData[3].value,
                    quarter = "${sampleMobileDataUsageDBData[3].year}-${sampleMobileDataUsageDBData[3].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[4].id,
                    volume = sampleMobileDataUsageDBData[4].value,
                    quarter = "${sampleMobileDataUsageDBData[4].year}-${sampleMobileDataUsageDBData[4].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[5].id,
                    volume = sampleMobileDataUsageDBData[5].value,
                    quarter = "${sampleMobileDataUsageDBData[5].year}-${sampleMobileDataUsageDBData[5].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[6].id,
                    volume = sampleMobileDataUsageDBData[6].value,
                    quarter = "${sampleMobileDataUsageDBData[6].year}-${sampleMobileDataUsageDBData[6].quarter}"
                ),
                DataUsageRecord(
                    id = sampleMobileDataUsageDBData[7].id,
                    volume = sampleMobileDataUsageDBData[7].value,
                    quarter = "${sampleMobileDataUsageDBData[7].year}-${sampleMobileDataUsageDBData[7].quarter}"
                )
            )
        )
    )
}