package com.meal.planner.recipe

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.meal.design.ui.FilterComponent
import com.meal.design.ui.StaggeredList
import com.meal.network.model.RecipeCollectionResponse
import com.meal.planner.recipedetail.RecipeDetailActivity
import com.meal.planner.viewmodel.RecipeCollectionPageState
import com.meal.planner.viewmodel.RecipeCollectionViewModel
import com.meal.planner.viewmodel.RecipeDetailViewModel

@Composable
fun RecipeCollectionScreen(viewModel: RecipeCollectionViewModel) {
    val recipeCollectionPageState  = viewModel.recipeCollectionPageLiveData.observeAsState()
    if ((recipeCollectionPageState.value is RecipeCollectionPageState.Error).not() && recipeCollectionPageState.value != null) {
        when (recipeCollectionPageState.value) {
            is RecipeCollectionPageState.Loading -> {
                Loading()
            }
            is RecipeCollectionPageState.Success -> {
                val response = (recipeCollectionPageState.value as RecipeCollectionPageState.Success).response
                RecipeCollectionContent(response)
            }
            else -> {
                Loading()
            }
        }
    } else {
        //TODO:Show error screen
    }
}

@Composable
fun RecipeCollectionContent(response: RecipeCollectionResponse) {
    val context = LocalContext.current
    Column(modifier = Modifier.background(Color.White)) {
        FilterComponent(response.filters)
        Spacer(modifier = Modifier.height(8.dp))
        StaggeredList(recipeList = response.recipeItems) {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra("id", it.id)
            intent.putExtra("name", it.name)
            intent.putExtra("image", it.image)
            context.startActivity(intent)
        }
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(48.dp)
                .background(color = Color.White, shape = CircleShape),
            strokeWidth = 2.dp,
            color = Color.Blue // You can customize the color
        )
    }
}