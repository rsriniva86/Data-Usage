package com.demo.datausage.consumption.qtr

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Velocity
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.demo.datausage.common.logging.EventLogMessenger
import com.demo.datausage.domainmodels.Datatype
import com.demo.datausage.domainmodels.QuarterWiseData
import com.demo.datausage.features.consumption.qtr.R
import kotlinx.coroutines.launch
import org.koin.androidx.compose.getViewModel


private const val MESSAGE_STARTED = "Year Detail Screen (Quarter wise) started"
private const val MESSAGE_SHOWING_YEAR = "Year Detail Screen (Quarter wise) showing for year:"
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun QtrScreen(
    navController: NavController,
    year: Long,
    qtrScreenViewModel: QtrScreenViewModel
) {
    val data = qtrScreenViewModel.list.toList()
    val context = LocalContext.current
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(Unit) {
        EventLogMessenger.sendMessage(context, MESSAGE_STARTED)
        qtrScreenViewModel.currentYear.value = year
        qtrScreenViewModel.getQuarterData()
    }
    LaunchedEffect(qtrScreenViewModel.index.value) {
        if (listState.firstVisibleItemIndex != qtrScreenViewModel.index.value) {
            EventLogMessenger.sendMessage(
                context, "${MESSAGE_SHOWING_YEAR} ${qtrScreenViewModel.currentYear.value}"
            )
            listState.scrollToItem(index = qtrScreenViewModel.index.value)
        }
    }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override suspend fun onPostFling(consumed: Velocity, available: Velocity): Velocity {
                // On scroll ended detection
                coroutineScope.launch {
                    if (listState.firstVisibleItemIndex != qtrScreenViewModel.index.value) {
                        qtrScreenViewModel.setCurrentYear(
                            listState.firstVisibleItemIndex
                        )
                        EventLogMessenger.sendMessage(
                            context, "${MESSAGE_SHOWING_YEAR} ${qtrScreenViewModel.currentYear.value}"
                        )
                    }
                }

                return super.onPostFling(consumed, available)
            }
        }
    }
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(start = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = context.getString(R.string.back_icon_content_description),
                        modifier = Modifier.clickable {
                            navController.popBackStack()
                        })
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = context.getString(R.string.qtr_screen_title),
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
        )
    }) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.surface)
        ) {
            LazyRow(
                modifier = Modifier
                    .nestedScroll(nestedScrollConnection)
                    .fillMaxSize()
                    .padding(top = 160.dp),
                state = listState
            ) {
                items(
                    data
                ) {
                    QuarterWiseItem(
                        dataItem = it,
                        modifier = Modifier
                            .fillParentMaxWidth(0.95f)
                    )
                }
            }
        }
    }
}

@Composable
private fun QuarterWiseItem(
    dataItem: QuarterWiseData,
    modifier: Modifier
) {
    val context = LocalContext.current
    Column(modifier = modifier) {
        Row {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "${dataItem.year}",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(96.dp))
        if(dataItem.qOneValue.isNotEmpty()){
            QuarterCard(
                label = context.getString(R.string.q1_label),
                data = dataItem.qOneValue
            )
        }
        if(dataItem.qTwoValue.isNotEmpty()) {
            QuarterCard(
                label = context.getString(R.string.q2_label),
                data = dataItem.qTwoValue
            )
        }
        if(dataItem.qThreeValue.isNotEmpty()) {
            QuarterCard(
                label = context.getString(R.string.q3_label),
                data = dataItem.qThreeValue
            )
        }
        if(dataItem.qFourValue.isNotEmpty()){
            QuarterCard(
                label = context.getString(R.string.q4_label),
                data = dataItem.qFourValue
            )
        }


    }

}

@Composable
fun QuarterCard(
    modifier: Modifier = Modifier,
    data: String,
    label: String
) {
    Card(
        modifier = modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primary)
                .padding(all = 8.dp)
                .fillMaxWidth()
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "$label : $data",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewQtrScreen() {
    val navController = rememberNavController()
    QtrScreen(
        navController = navController,
        year = 2010,
        qtrScreenViewModel = getViewModel()
    )
}