package com.meal.planner.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.meal.design.ui.MPTextBold
import com.meal.planner.home.HomeScreen
import com.meal.planner.viewmodel.HomeViewModel

@ExperimentalMaterial3Api
@Composable
fun NavigationGraph(navController: NavHostController, homeViewModel: HomeViewModel) {
    NavHost(navController, startDestination = Destinations.HomeScreen.route) {
        composable(Destinations.HomeScreen.route) {
            HomeScreen(homeViewModel)
        }
        composable(Destinations.PlanScreen.route) {
            CartScreen()
        }
        composable(Destinations.Cart.route) {
            CartScreen()
        }
        composable(Destinations.Account.route) {
            CartScreen()
        }
    }
}

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .wrapContentSize(Alignment.Center)
    ) {
        MPTextBold(
            title = "Favourite Screen",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
    }
}

