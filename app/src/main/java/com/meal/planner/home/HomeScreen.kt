package com.meal.planner.home

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meal.design.ui.CategoryCarousel
import com.meal.design.ui.CategoryTitle
import com.meal.design.ui.SearchBox
import com.meal.network.model.HomePageResponse
import com.meal.planner.recipe.RecipeCollectionActivity
import com.meal.planner.viewmodel.HomePageState
import com.meal.planner.viewmodel.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val homePageState  = viewModel.homePageLiveData.observeAsState()
    if ((homePageState.value is HomePageState.Error).not() && homePageState.value != null) {
        when (homePageState.value) {
            is HomePageState.Loading -> {
                Loading()
            }
            is HomePageState.Success -> {
                val categories = (homePageState.value as HomePageState.Success).response.categories
                categories?.let {
                    HomeContent(it)
                }
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
fun HomeContent(categories: List<HomePageResponse.Category>) {
    var searchText by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(start = 16.dp, top = 16.dp),) {
        CategoryTitle(
            category = "Explore",
            style = TextStyle(color = Color.Black, fontSize = 24.sp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        SearchBox(
            text = searchText,
            onTextChanged = { newText ->
                searchText = newText
            },
            onSearchClicked = {
                // Handle the search action here
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(categories.size) { index ->
                CategoryTitle(category = categories[index].name.orEmpty())
                Spacer(modifier = Modifier.height(16.dp))
                CategoryCarousel(categories[index].subCategories) {
                    val intent = Intent(context, RecipeCollectionActivity::class.java)
                    intent.putExtra("name", it)
                    context.startActivity(intent)
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.White),
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