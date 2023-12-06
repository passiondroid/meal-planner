package com.meal.network.model

import com.google.gson.annotations.SerializedName

data class IngrediantsTO(
    @SerializedName("qty")
    val qty: String,
    @SerializedName("name")
    val name:String
)

