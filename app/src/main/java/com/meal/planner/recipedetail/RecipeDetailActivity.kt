package com.meal.planner.recipedetail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import com.meal.design.ui.MPTextBold
import com.meal.design.ui.theme.MealPlannerTheme
import com.meal.planner.viewmodel.RecipeCollectionViewModel
import com.meal.planner.viewmodel.RecipeDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeDetailActivity: FragmentActivity() {

    private val viewModel: RecipeDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val id = intent.getIntExtra("id", 0)
            val name = intent.getStringExtra("name")
            val image = intent.getStringExtra("image")
            MealPlannerTheme {
                viewModel.getRecipeDetails(id, name.orEmpty(), image.orEmpty())
                RecipeDetailScreen(viewModel = viewModel)
            }
        }
    }
}