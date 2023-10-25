package com.meal.design.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.meal.design.R
import com.meal.design.ui.Utils.GRADIENT
import com.meal.design.ui.Utils.getImageRequest
import com.meal.network.model.HomePageResponse

@Composable
fun CategoryCarousel(subCategories: List<HomePageResponse.SubCategory>, onClick: (name: String) -> Unit) {
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxSize()) {
        items(subCategories.size) { index ->
            Box(
                modifier = Modifier
                .width(120.dp)
                .height(120.dp)
                    .shadow(shape = RoundedCornerShape(4.dp), elevation = 1.dp)
                .clickable {
                    onClick(subCategories[index].name.orEmpty())
                }
            ) {
                Surface(
                    modifier = Modifier
                        .width(120.dp)
                        .height(120.dp),
                    shadowElevation = 4.dp,
                ) {
                    AsyncImage(
                        model = getImageRequest(subCategories[index].image, LocalContext.current),
                        placeholder = painterResource(R.drawable.placeholder),
                        contentDescription = "",
                        contentScale = ContentScale.Crop,
                    )
                }
                Box(modifier = Modifier
                    .background(GRADIENT)
                    .height(80.dp)
                    .fillMaxWidth()
                    .align(Alignment.BottomEnd)
                )
                MPText(
                    title = subCategories[index].name.orEmpty(),
                    style = TextStyle(color = Color.White),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(modifier: Modifier = Modifier, category: String, style: TextStyle = TextStyle(color = Color.Black)) {
    MPTextBold(modifier = modifier, title = category, style = style)
}
