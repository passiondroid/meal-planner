package com.meal.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("filters")
    val filters: List<String>,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("serving")
    val serving: String,
    @SerializedName("prep")
    val prep: String,
    @SerializedName("cooking_time")
    val cookingTime: String,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("ingredients")
    val ingredients: Ingredients,
    @SerializedName("instructions")
    val instructions: Instructions,
) {
    data class Ingredients(
        @SerializedName("quantities")
        val quantities: Map<String, String>,
        @SerializedName("product")
        val products: List<Product>,
        @SerializedName("total_items")
        val totalItems: String,
        @SerializedName("estimated_total")
        val estimatedTotal: String,
    ) {
        data class Product(
            @SerializedName("title")
            val title: String,
            @SerializedName("sub_title")
            val subTitle: String,
            @SerializedName("price")
            val price: String,
            @SerializedName("quantity")
            val quantity: String,
            @SerializedName("image")
            val image: String,
        )
    }

    data class Instructions(
        @SerializedName("title")
        val title: String,
        @SerializedName("prep")
        val prep: String,
        @SerializedName("cooking-time")
        val cookingTime: String,
        @SerializedName("steps")
        val steps: List<String>,
    )
}
