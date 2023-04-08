package com.demo.datausage.core.repository.mappers

import android.util.Log
import com.demo.datausage.core.data.datasource.local.database.entities.MobileDataUsageDB
import com.demo.datausage.core.data.datasource.remote.dto.DataUsageResponse
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.domainmodels.YearWiseData
import java.math.BigDecimal


enum class Quarter{
    Q1,
    Q2,
    Q3,
    Q4,
    UNKNOWN
}
data class QuarterSpecificData(
    val year:Long,
    val quarter:Quarter,
    val value:String
)


object DBDataMapper{
    fun mapFromResponse(response:DataUsageResponse):List<MobileDataUsageDB>{

        val dbList = mutableListOf<MobileDataUsageDB>()
        response.result?.records?.forEach {
            Log.d("DEMO","QTR:${it.quarter}")
            val year = it.quarter.substring(0, 4).toLongOrNull() ?: 0L
            val qtr = when (it.quarter.substring(5)) {
                "Q1" -> Quarter.Q1
                "Q2" -> Quarter.Q2
                "Q3" -> Quarter.Q3
                "Q4" -> Quarter.Q4
                else -> Quarter.UNKNOWN
            }
            if (qtr != Quarter.UNKNOWN) {
                val dbData = MobileDataUsageDB(
                    id = it.id,
                    value = it.volume,
                    year = year,
                    quarter = qtr.name
                )
                Log.d("DEMO","$dbData")

                dbList.add(dbData)
            }
        }
        Log.d("DEMO","$dbList")

        return dbList

    }
}
object YearWiseDataMapper{

    fun mapToYearWiseDataList(dbData: List<MobileDataUsageDB>): List<YearWiseData> {
        val groupedList= internalMappingToGroupedQuarterSpecificData(dbData = dbData)
        return  groupedDataToYearWiseDataList(groupedList)
    }
    private fun groupedDataToYearWiseDataList(groupedList: Map<Long, List<QuarterSpecificData>>): List<YearWiseData> {
        val yearWiseDataList = mutableListOf<YearWiseData>()
        groupedList.forEach { (year, data) ->
            var value :BigDecimal = BigDecimal.valueOf(0)
            data.forEach {
                value += it.value.toBigDecimal()
            }

            yearWiseDataList.add(
                YearWiseData(
                    year = year,
                    dataType = Datatype.MOBILE_DATA_USAGE,
                    value = value.toString()
                )
            )
        }
        Log.d("TAG","$yearWiseDataList")
        return yearWiseDataList
    }


}

object QuarterWiseDataMapper {

    fun mapToQuarterWiseDataList(response: DataUsageResponse): List<QuarterWiseData> {

        val quarterWiseDataList = mutableListOf<QuarterWiseData>()
        val groupedList = internalMappingToGroupedQuarterSpecificData(response = response)
        groupedList.forEach { (year, data) ->
            var q1Value: String = ""
            var q2Value: String = ""
            var q3Value: String = ""
            var q4Value: String = ""

            data.forEach {

                when (it.quarter) {
                    Quarter.Q1 -> {
                        q1Value = it.value
                    }

                    Quarter.Q2 -> {
                        q2Value = it.value
                    }

                    Quarter.Q3 -> {
                        q3Value = it.value
                    }

                    Quarter.Q4 -> {
                        q4Value = it.value
                    }

                    Quarter.UNKNOWN -> {

                    }
                }

            }

            quarterWiseDataList.add(
                QuarterWiseData(
                    year = year,
                    dataType = Datatype.MOBILE_DATA_USAGE,
                    qOneValue = q1Value,
                    qTwoValue = q2Value,
                    qThreeValue = q3Value,
                    qFourValue = q4Value
                )
            )
        }
        return quarterWiseDataList
    }
}

private fun internalMappingToGroupedQuarterSpecificData(dbData: List<MobileDataUsageDB>): Map<Long, List<QuarterSpecificData>> {

    val qtrSpecificList = mutableListOf<QuarterSpecificData>()
    dbData.forEach {
        Log.d("DEMO","QTR:${it.quarter}")
        val year = it.year
        val qtr= when(it.quarter){
            "Q1" -> Quarter.Q1
            "Q2" -> Quarter.Q2
            "Q3" -> Quarter.Q3
            "Q4" -> Quarter.Q4
            else -> Quarter.UNKNOWN

        }
        val qtrSpecificData = QuarterSpecificData(
            year = year,
            quarter = qtr,
            value = it.value.toString()
        )
        Log.d("TAG","qtrSpecificData:${qtrSpecificData}")

        if(qtrSpecificData.quarter != Quarter.UNKNOWN) {
            qtrSpecificList.add(qtrSpecificData)
        }
    }
    Log.d("TAG","QTRSpecificList:${qtrSpecificList}")

    val groupedList= qtrSpecificList.groupBy {
        it.year
    }
    Log.d("TAG","groupedList:${groupedList}")

    return groupedList

}

private fun internalMappingToGroupedQuarterSpecificData(response:DataUsageResponse): Map<Long, List<QuarterSpecificData>> {

    val qtrSpecificList = mutableListOf<QuarterSpecificData>()
    response.result?.records?.forEach {
        Log.d("DEMO","QTR:${it.quarter}")
        val year = it.quarter.substring(0,4)
        val qtr= when(it.quarter.substring(5)){
            "Q1" -> Quarter.Q1
            "Q2" -> Quarter.Q2
            "Q3" -> Quarter.Q3
            "Q4" -> Quarter.Q4
            else -> Quarter.UNKNOWN
        }
        val qtrSpecificData = QuarterSpecificData(
            year = year.toLongOrNull()?:0L,
            quarter = qtr,
            value = it.volume.toString()
        )
        Log.d("TAG","qtrSpecificData:${qtrSpecificData}")

        if(qtrSpecificData.quarter != Quarter.UNKNOWN) {
            qtrSpecificList.add(qtrSpecificData)
        }
    }
    Log.d("TAG","QTRSpecificList:${qtrSpecificList}")

    val groupedList= qtrSpecificList.groupBy {
        it.year
    }
    Log.d("TAG","groupedList:${groupedList}")

    return groupedList

}