package com.meal.network

import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse

interface RecipeRepository {
    suspend fun getRecipeCollections(): RecipeCollectionResponse
    suspend fun getRecipeDetails(id: Int, name: String, image: String): RecipeDetailResponse
}