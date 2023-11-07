package com.meal.network.api

import com.meal.network.model.HomePageResponse
import com.meal.network.model.Product
import com.meal.network.model.ProductRequestTO
import com.meal.network.model.ProductRespTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface MealPlannerApi {

    @POST("functions/v1/get-home-page")
    suspend fun getHomePage(): HomePageResponse

    @POST("MealPlanner")
    suspend fun getRecipeDetails(@Body productRequestTO: ProductRequestTO) : Response<ProductRespTO>

}