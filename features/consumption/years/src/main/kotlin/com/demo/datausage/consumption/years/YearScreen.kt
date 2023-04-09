package com.demo.datausage.consumption.years

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.demo.datausage.domainmodels.DataUsageScreens
import com.demo.datausage.domainmodels.YearWiseData
import org.koin.androidx.compose.getViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YearScreen(
    navController: NavController, yearScreenViewModel: YearScreenViewModel
) {
    val data = yearScreenViewModel.list.toList()
    LaunchedEffect(Unit) {
        yearScreenViewModel.getYearData()
    }

    Scaffold(topBar = {
        TopAppBar(title = {
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Year Screen",
                    style = MaterialTheme.typography.headlineLarge
                    )
            }
        })
    }) {

        LazyColumn(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .fillMaxWidth()
                .padding(top = 60.dp)
        ) {
            items(data) {
                YearItem(
                    navController = navController, dataItem = it
                )
            }
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun YearItem(
    dataItem: YearWiseData, navController: NavController
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth(),
        onClick = {
        navController.navigate(DataUsageScreens.QtrScreen.route + "/${dataItem.year}")
    }) {
        Column(
            modifier =
            Modifier
                .background(MaterialTheme.colorScheme.primary)
                .fillMaxWidth()
                .padding(all = 8.dp)
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Year : ",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center

                )
                Text(
                    text = "${dataItem.year}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Usage : ",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "${dataItem.value}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )
            }
        }
    }


}

@Preview
@Composable
private fun PreviewYearScreen() {
    val navController = rememberNavController()
    YearScreen(
        navController = navController, yearScreenViewModel = getViewModel<YearScreenViewModel>()
    )
}