package com.meal.planner.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.meal.design.ui.MPText
import com.meal.design.ui.theme.MealPlannerTheme
import com.meal.design.ui.theme.White
import com.meal.planner.navigation.Destinations
import com.meal.planner.navigation.NavigationGraph
import com.meal.planner.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

@ExperimentalMaterial3Api
class HomeActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPlannerTheme {
                val navController: NavHostController = rememberNavController()
                val buttonsVisible = remember { mutableStateOf(true) }
                homeViewModel.getHomePage()
                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            state = buttonsVisible,
                            modifier = Modifier
                        )
                    }) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        NavigationGraph(navController = navController, homeViewModel)
                    }
                }
            }
        }
    }

    @Composable
    fun BottomBar(
        navController: NavHostController, state: MutableState<Boolean>,
        modifier: Modifier = Modifier
    ) {
        val screens = listOf(
            Destinations.HomeScreen, Destinations.PlanScreen, Destinations.Cart, Destinations.Account
        )

        NavigationBar(
            modifier = modifier,
            containerColor = White,
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->

                NavigationBarItem(
                    label = {
                        MPText(title = screen.title!!)
                    },
                    icon = {
                        Icon(imageVector = screen.icon!!, contentDescription = "")
                    },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                )
            }
        }
    }
}