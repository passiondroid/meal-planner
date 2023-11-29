package com.meal.planner.viewmodel

import com.meal.network.model.FetchProducts
import com.meal.network.model.HomePageResponse
import com.meal.network.model.ProductRespTO
import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse
import retrofit2.Response


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
sealed class RecipeDetailsProductPageState() {
    data class Success(val response: Response<FetchProducts>) : RecipeDetailsProductPageState()
    data class Error(val errorMessage: String) : RecipeDetailsProductPageState()
    object Loading : RecipeDetailsProductPageState()
}
