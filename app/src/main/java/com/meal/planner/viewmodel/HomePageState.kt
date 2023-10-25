package com.meal.planner.viewmodel

import com.meal.network.model.HomePageResponse
import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse


sealed class HomePageState() {
    data class Success(val response: HomePageResponse) : HomePageState()
    data class Error(val errorMessage: String) : HomePageState()
    object Loading : HomePageState()
}

sealed class RecipeCollectionPageState() {
    data class Success(val response: RecipeCollectionResponse) : RecipeCollectionPageState()
    data class Error(val errorMessage: String) : RecipeCollectionPageState()
    object Loading : RecipeCollectionPageState()
}

sealed class RecipeDetailPageState() {
    data class Success(val response: RecipeDetailResponse) : RecipeDetailPageState()
    data class Error(val errorMessage: String) : RecipeDetailPageState()
    object Loading : RecipeDetailPageState()
}
