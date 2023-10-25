package com.meal.network

import com.meal.network.model.HomePageResponse

interface HomeRepository {
    suspend fun getHomePage(): HomePageResponse
}