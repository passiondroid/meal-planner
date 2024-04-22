package com.meal.network.model


import com.google.gson.annotations.SerializedName

data class HomePageResponse(
    @SerializedName("categories")
    val categories: MutableList<Category>,
) {
    data class Category(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        var name: String,
        @SerializedName("sub_categories")
        val subCategories: MutableList<SubCategory>,
    )

    data class SubCategory(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        var name: String,
        @SerializedName("image_url")
        val image: String?,
    )
}