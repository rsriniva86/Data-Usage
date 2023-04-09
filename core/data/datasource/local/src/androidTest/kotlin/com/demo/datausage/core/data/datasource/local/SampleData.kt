package com.demo.datausage.core.data.datasource.local

import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB


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
}