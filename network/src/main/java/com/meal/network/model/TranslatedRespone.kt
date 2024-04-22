package com.meal.network.model


import com.google.gson.annotations.SerializedName

data class TranslatedRespone(
    @SerializedName("originalText")
    val originalText: String?,
    @SerializedName("translatedText")
    val translatedText: String?
)
