package com.demo.datausage.domainmodels


enum class Datatype{
    MOBILE_DATA_USAGE
}
data class YearWiseData(
    val year:Int,
    val dataType:Datatype,
    val value:String
)

data class QuarterWiseData(
    val year:Int,
    val dataType:Datatype,
    val qOneValue:String,
    val qTwoValue:String,
    val qThreeValue:String,
    val qFourValue:String
)
