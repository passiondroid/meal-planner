package com.meal.design.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.meal.design.ui.Utils.GRADIENT
import com.meal.network.model.RecipeCollectionResponse

@Composable
fun FilterComponent(filters: List<RecipeCollectionResponse.Filter>) {
    var selectedFilter by remember { mutableStateOf<RecipeCollectionResponse.Filter?>(filters[0]) }
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        items(filters.size) {
            val filter = filters[it]
            val isSelected = filter == selectedFilter
            MPText(
                title = filter.name,
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = if (isSelected) Color(0xFF0096FF) else Color.Transparent,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color(0xFF0096FF),
                        shape = CircleShape
                    )
                    .clickable {
                        selectedFilter = filter
                    }
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                style = TextStyle(
                    color = if (isSelected) Color.White else Color.Black,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 16.sp
                ),
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaggeredList(recipeList: List<RecipeCollectionResponse.RecipeItem>,
                  onItemClick: (recipeItem: RecipeCollectionResponse.RecipeItem) -> Unit) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(recipeList.size) { index ->
                Box(modifier = Modifier
                    .clickable { onItemClick(
                        recipeList[index]
                    ) }
                    .shadow(shape = RoundedCornerShape(4.dp), elevation = 1.dp)
                ) {
                    AsyncImage(
                        model = Utils.getImageRequest(recipeList[index].image, LocalContext.current),
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                    )
                    Box(modifier = Modifier
                        .height(120.dp)
                        .fillMaxWidth()
                        .background(GRADIENT)
                        .align(Alignment.BottomEnd))
                    MPText(
                        title = recipeList[index].name.orEmpty(),
                        style = TextStyle(color = Color.White, fontSize = 18.sp),
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(start = 8.dp, bottom = 8.dp, end = 16.dp)
                    )
                }
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp),
    )
}