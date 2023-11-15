package com.meal.network.model

import com.google.gson.annotations.SerializedName

data class IngrediantsTO(
    @SerializedName("quantities")
    val qty: String,
    @SerializedName("name")
    val name:String
)

