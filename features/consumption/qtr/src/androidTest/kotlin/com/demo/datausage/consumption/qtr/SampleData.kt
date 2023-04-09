package com.demo.datausage.consumption.qtr

import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.QuarterWiseData

object SampleData {
    val sampleQuarterWiseDataList = listOf(
        QuarterWiseData(
            year = 2011,
            dataType = Datatype.MOBILE_DATA_USAGE,
            qOneValue = "1",
            qTwoValue = "2",
            qThreeValue = "3",
            qFourValue = "4"
        ),
        QuarterWiseData(
            year = 2012,
            dataType = Datatype.MOBILE_DATA_USAGE,
            qOneValue = "10",
            qTwoValue = "20",
            qThreeValue = "30",
            qFourValue = "40"
        ),
        QuarterWiseData(
            year = 2013,
            dataType = Datatype.MOBILE_DATA_USAGE,
            qOneValue = "101",
            qTwoValue = "201",
            qThreeValue = "301",
            qFourValue = "401"
        ),
        QuarterWiseData(
            year = 2014,
            dataType = Datatype.MOBILE_DATA_USAGE,
            qOneValue = "1001",
            qTwoValue = "2001",
            qThreeValue = "3001",
            qFourValue = "4001"
        ),
        QuarterWiseData(
            year = 2015,
            dataType = Datatype.MOBILE_DATA_USAGE,
            qOneValue = "5001",
            qTwoValue = "6002",
            qThreeValue = "7003",
            qFourValue = "8004"
        ),
    )

}