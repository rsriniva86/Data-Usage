package com.demo.datausage.consumption.years

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.demo.datausage.domainmodels.DataUsageScreens
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.YearWiseData

@Composable
fun YearScreen(navController: NavController) {
    val data = provideDummyData().toList()

    Column{
        Text(
            modifier = Modifier
                .fillMaxWidth()
            ,
            textAlign = TextAlign.Center,
            text = "Year Screen",

        )
        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(data){
                YearItem(
                    navController = navController,
                    dataItem = it
                )
            }
        }
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun YearItem(
    dataItem: YearWiseData,
    navController:NavController
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        onClick = {
            navController.navigate(DataUsageScreens.QtrScreen.route+ "/${dataItem.year}")
        }
    ) {
        Column (modifier =Modifier.padding(all =8.dp)){
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


}

fun provideDummyData(): List<YearWiseData> {

    val startYear = 2000
    val startValue = 100

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
    val navController = rememberNavController()
    YearScreen(navController = navController)
}