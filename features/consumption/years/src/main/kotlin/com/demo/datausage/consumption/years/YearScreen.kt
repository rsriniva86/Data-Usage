package com.demo.datausage.consumption.years

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.YearWiseData

@Composable
fun YearScreen() {
    val data = provideDummyData().toList()

    Column{
        Text(text = "Year Screen")
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(data){
                YearItem(dataItem = it)
            }
        }
    }


}

@Composable
private fun YearItem(dataItem: YearWiseData) {
    Column {
        Row {
            Text(text = "Year : ")
            Text (text= "${dataItem.year}")
        }
        Row {
            Text(text = "Usage : ")
            Text (text= "${dataItem.value}")
        }
    }

}

fun provideDummyData(): List<YearWiseData> {

    val startYear = 2000
    val startValue = 101

    val list = mutableListOf<YearWiseData>()

    for (index in 1..22) {
        val value = startValue + index
        val year = startYear + index
        list.add(
            YearWiseData(
                year = year, dataType = Datatype.MOBILE_DATA_USAGE, value = "$value"
            )
        )
    }
    return list

}

@Preview
@Composable
private fun PreviewYearScreen() {
    YearScreen()
}