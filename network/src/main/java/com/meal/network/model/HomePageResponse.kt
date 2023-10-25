package com.meal.network.model


import com.google.gson.annotations.SerializedName

data class HomePageResponse(
    @SerializedName("categories")
    val categories: List<Category>?,
) {
    data class Category(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("sub_categories")
        val subCategories: List<SubCategory>,
    )

    data class SubCategory(
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("image_url")
        val image: String?,
    )
}