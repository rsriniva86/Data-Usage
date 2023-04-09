package com.demo.datausage.consumption.years

import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.YearWiseData

object SampleData {

    val sampleYearWiseData = listOf(
        YearWiseData(
            year = 2004,
            dataType = Datatype.MOBILE_DATA_USAGE,
            value = "101.0"
        ),
        YearWiseData(
            year = 2005,
            dataType = Datatype.MOBILE_DATA_USAGE,
            value = "102.0"
        ),
        YearWiseData(
            year = 2006,
            dataType = Datatype.MOBILE_DATA_USAGE,
            value = "103.0"
        ),
        YearWiseData(
            year = 2007,
            dataType = Datatype.MOBILE_DATA_USAGE,
            value = "104.0"
        ),
        YearWiseData(
            year = 2008,
            dataType = Datatype.MOBILE_DATA_USAGE,
            value = "105.0"
        )
    )
}