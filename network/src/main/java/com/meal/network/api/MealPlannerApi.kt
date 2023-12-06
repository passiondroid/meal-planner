package com.meal.network.api

import com.meal.network.model.FetchProducts
import com.meal.network.model.ProductRequestTO
import com.meal.network.model.Products
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface MealPlannerApi {

    @Headers("qa_access: true", "User-Agent: ResourceOptimizer")
    @POST("api/mp")
    suspend fun getRecipeDetails(@Body productRequestTO: ProductRequestTO) : Products

//    @GET("meal-planner/products.json")
//    suspend fun getRecipeDetails() : Products

    @GET("654b5e1f12a5d37659967d5a")
    suspend fun getRecipeDetailsProducts() : Response<FetchProducts>

}