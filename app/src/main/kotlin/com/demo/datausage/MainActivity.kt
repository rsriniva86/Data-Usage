package com.demo.datausage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.demo.datausage.common.theme.DataUsageMaterial3Theme
import com.demo.datausage.consumption.qtr.QtrScreen
import com.demo.datausage.consumption.years.YearScreen

class MainActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataUsageMaterial3Theme {
                QtrScreen()
            }
        }
    }
}