package com.meal.network

import com.meal.network.model.FetchProducts
import com.meal.network.model.ProductRespTO
import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse
import retrofit2.Response

interface RecipeRepository {
    suspend fun getRecipeCollections(): RecipeCollectionResponse
    suspend fun getRecipeDetails(id: Int, name: String, image: String): RecipeDetailResponse

}