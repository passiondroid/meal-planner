package com.meal.design.ui

import android.content.Context
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import coil.request.ImageRequest
import com.meal.design.R

object Utils {

    fun getImageRequest(imageUrl: String?, context: Context): ImageRequest {
        val data =  if (imageUrl?.isEmpty() == true) {
            R.drawable.placeholder
        } else {
            imageUrl
        }
        return ImageRequest.Builder(context)
            .data(data)
            .crossfade(true)
            .build()
    }

    val GRADIENT = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color(0xBF000000)),
    )

    val REVERSE_GRADIENT = Brush.verticalGradient(
        colors = listOf(Color(0xBF000000), Color.Transparent),
    )

    val HIGHLIGHT_COLOR = Color(0xFF0372BE)
}