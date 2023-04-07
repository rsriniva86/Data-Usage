package com.demo.datausage.domainmodels

sealed class DataUsageScreens(val route: String) {
    object YearScreen : DataUsageScreens("year_screen")
    object QtrScreen : DataUsageScreens("qtr_screen")
}
