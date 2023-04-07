package com.demo.datausage.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.demo.datausage.consumption.qtr.QtrScreen
import com.demo.datausage.consumption.qtr.QtrScreenViewModel
import com.demo.datausage.consumption.years.YearScreen
import com.demo.datausage.consumption.years.YearScreenViewModel
import com.demo.datausage.domainmodels.DataUsageScreens
import org.koin.androidx.compose.getViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = DataUsageScreens.YearScreen.route) {
        composable(route = DataUsageScreens.YearScreen.route) {
            val yearScreenViewModel  = getViewModel<YearScreenViewModel>()
            YearScreen(
                navController = navController,
                yearScreenViewModel = yearScreenViewModel
            )
        }
        composable(
            route = DataUsageScreens.QtrScreen.route + "/{year}",
            arguments = listOf(navArgument(name = "year") {
                type = NavType.IntType
            })
        ) { entry ->
            val qtrScreenViewModel  = getViewModel<QtrScreenViewModel>()

            QtrScreen(
                navController=navController,
                year = entry.arguments?.getInt("year"),
                qtrScreenViewModel = qtrScreenViewModel
            )
        }
    }
}