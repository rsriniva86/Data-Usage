package com.demo.datausage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.demo.datausage.common.theme.DataUsageMaterial3Theme
import com.demo.datausage.navigation.Navigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DataUsageMaterial3Theme {
                Navigation()
            }
        }
    }
}