package com.meal.planner.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String? = null,
    val icon: ImageVector? = null
) {
    object HomeScreen : Destinations(
        route = "home_screen",
        title = "Home",
        icon = Icons.Outlined.Home
    )

    object PlanScreen : Destinations(
        route = "plan_screen",
        title = "My Plan",
        icon = Icons.Outlined.Home
    )

    object Cart : Destinations(
        route = "cart_screen",
        title = "Cart",
        icon = Icons.Outlined.ShoppingCart
    )

    object Account : Destinations(
        route = "account_screen",
        title = "Profile",
        icon = Icons.Outlined.AccountCircle
    )

}