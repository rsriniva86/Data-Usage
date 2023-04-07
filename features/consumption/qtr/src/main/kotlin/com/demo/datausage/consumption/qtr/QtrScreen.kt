package com.demo.datausage.consumption.qtr

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.QuarterWiseData

@Composable
fun QtrScreen(
    navController: NavController,
    year: Int?
) {
    val data = provideDummyData().toList()

    Column {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = "Year Details Screen",

            )

        LazyRow(modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp)
        ) {
            items(
                data
            ) {

                QuarterWiseItem(
                    dataItem = it,
                    modifier = Modifier
                        .fillParentMaxWidth(0.9f)
                        .align(CenterHorizontally)
                )
            }
        }
    }


}

@Composable
private fun QuarterWiseItem(
    dataItem: QuarterWiseData,
    modifier: Modifier
) {
    Column (modifier =modifier){
        Row (modifier = Modifier
            .fillMaxWidth()
        ){
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Year : ${dataItem.year}",
                textAlign = TextAlign.Center
            )
        }
        QuarterCard(
            label ="Q1",
            data = dataItem.qOneValue
        )
        QuarterCard(
            label ="Q2",
            data = dataItem.qTwoValue
        )
        QuarterCard(
            label ="Q3",
            data = dataItem.qThreeValue
        )
        QuarterCard(
            label ="Q4",
            data = dataItem.qFourValue
        )

    }
}

@Composable
fun QuarterCard(
    modifier: Modifier = Modifier,
    data: String,
    label:String
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "$label : $data",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun provideDummyData(): List<QuarterWiseData> {

    val startYear = 2000
    val startValue = 100

    val list = mutableListOf<QuarterWiseData>()

    for (index in 1..22) {
        val valueOne = startValue + index
        val valueTwo = valueOne + index
        val valueThree = valueTwo + index
        val valueFour = valueThree + index

        val year = startYear + index
        list.add(
            QuarterWiseData(
                year = year,
                dataType = Datatype.MOBILE_DATA_USAGE,
                qOneValue = "$valueOne",
                qTwoValue = "$valueTwo",
                qThreeValue = "$valueThree",
                qFourValue = "$valueFour",


                )
        )
    }
    return list

}

@Preview
@Composable
private fun PreviewQtrScreen() {
    val navController = rememberNavController()
    QtrScreen(navController = navController, year = 2010)
}