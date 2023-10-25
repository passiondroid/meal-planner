package com.meal.network.api

import com.meal.network.model.HomePageResponse
import retrofit2.http.POST

interface MealPlannerApi {

    @POST("functions/v1/get-home-page")
    suspend fun getHomePage(): HomePageResponse
}