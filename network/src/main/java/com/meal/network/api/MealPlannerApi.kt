package com.meal.network.api

import com.meal.network.model.FetchProducts
import com.meal.network.model.HomePageResponse
import com.meal.network.model.ProductRequestTO
import com.meal.network.model.ProductRespTO
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface MealPlannerApi {

    @POST("functions/v1/get-home-page")
    suspend fun getHomePage(): HomePageResponse

    @POST("api/AsdaMealPlanner")
    suspend fun getRecipeDetails(@Body productRequestTO: ProductRequestTO) : List<ProductRespTO>

    @GET("654b5e1f12a5d37659967d5a")
    suspend fun getRecipeDetailsProducts() : Response<FetchProducts>

}