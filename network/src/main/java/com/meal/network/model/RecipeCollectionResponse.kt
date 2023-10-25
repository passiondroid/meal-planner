package com.meal.network.model


import com.google.gson.annotations.SerializedName

data class RecipeCollectionResponse(
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("recipeItems")
    val recipeItems: List<RecipeItem>,
) {
    data class Filter(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
    )

    data class RecipeItem(
        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("image_url")
        val image: String,
        @SerializedName("filter_ids")
        val filterIds: List<Int>,
    )
}