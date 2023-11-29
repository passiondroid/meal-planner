package com.meal.network.model


import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("products")
    val products: List<Product>?
) {
    data class Product(
        @SerializedName("cin")
        val cin: String?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("image_url")
        val imageUrl: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("price")
        val price: String?,
        @SerializedName("product_code")
        val productCode: String?,
        @SerializedName("quantity")
        val quantity: String?
    )
}