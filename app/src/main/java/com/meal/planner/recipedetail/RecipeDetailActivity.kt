package com.meal.planner.recipedetail

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import com.meal.design.ui.theme.MealPlannerTheme
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
            val qty = intent.getStringExtra("qty")
            MealPlannerTheme {
                viewModel.getRecipeDetails(id, name.orEmpty(), image.orEmpty())
                viewModel.getRecipeProducts(qty!!,name!!)
                RecipeDetailScreen(viewModel = viewModel,this)
            }
        }
    }
}