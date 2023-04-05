package com.demo.datausage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextField
import androidx.compose.material3.Text

class MainActivity: ComponentActivity() {

    @OptIn(
        ExperimentalFoundationApi::class,
        ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text="Hello")
        }
    }
}