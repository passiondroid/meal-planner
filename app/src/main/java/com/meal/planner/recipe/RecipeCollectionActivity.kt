package com.meal.planner.recipe

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.fragment.app.FragmentActivity
import com.meal.core.constants.Constants
import com.meal.design.ui.MPTextBold
import com.meal.design.ui.theme.MealPlannerTheme
import com.meal.planner.viewmodel.RecipeCollectionViewModel
import com.meal.planner.viewmodel.RecipeDetailViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeCollectionActivity: FragmentActivity() {

    private val viewModel: RecipeCollectionViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val name = intent.getStringExtra("name")
            MealPlannerTheme {
                viewModel.getRecipeCollectionPage()
                Scaffold( topBar = { TopBar(name.orEmpty()) }) {
                    Box(
                        modifier = Modifier.padding(it).background(Color.White)
                    ) {
                        RecipeCollectionScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TopBar(title: String) {
        var detailMenu by remember { mutableStateOf(false) }
        TopAppBar(
            title = {
                MPTextBold(title = title)
            },
            navigationIcon = {
                IconButton(
                    onClick = {
                        finish()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.Black
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.White)

        )
    }
}