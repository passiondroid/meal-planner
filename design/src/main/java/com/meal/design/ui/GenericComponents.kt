package com.meal.design.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.meal.core.constants.StringConstants
import com.meal.design.R
import com.meal.design.ui.Utils.HIGHLIGHT_COLOR
import com.meal.design.ui.theme.montserratBold
import com.meal.design.ui.theme.montserratRegular
import com.meal.network.model.FetchProducts
import com.meal.network.model.ProductRespTO
import com.meal.network.model.Products
import com.meal.network.model.RecipeDetailResponse
import kotlinx.coroutines.launch
import retrofit2.Response

@Composable
fun MPText(
    modifier: Modifier = Modifier, title: String,
    style: TextStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Normal)
) {
    Text(modifier = modifier, text = title, fontFamily = montserratRegular, style = style)
}

@Composable
fun AnnotatedMPText(
    modifier: Modifier = Modifier, title: String, boldTitle: String,
    style: TextStyle = TextStyle(color = Color.Black)
) {
    val annotatedText = buildAnnotatedString {
        append(title)
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
            )
        ) {
            append(boldTitle)
        }
    }
    Text(modifier = modifier, text = annotatedText, fontFamily = montserratRegular, style = style)
}

@Composable
fun MPTextBold(
    modifier: Modifier = Modifier, title: String,
    style: TextStyle = TextStyle(color = Color.Black),
    fontSize: TextUnit = 20.sp, maxlines: Int = 10
) {
    Text(
        modifier = modifier, text = title, fontFamily = montserratBold,
        fontSize = fontSize, style = style, maxLines = maxlines, overflow = TextOverflow.Ellipsis
    )
}

@Composable
fun MPButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier
            .shadow(shape = MaterialTheme.shapes.medium, elevation = 0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
    ) {
        MPText(title = text, style = TextStyle(color = Color.Black, textAlign = TextAlign.Center))
    }
}

@Composable
fun MPTab(modifier: Modifier, text: String, isSelected: Boolean, onClick: () -> Unit) {
    rememberUpdatedState(newValue = isSelected)
    val color = if (isSelected) HIGHLIGHT_COLOR else Color.White
    val textColor = if (isSelected) Color.White else HIGHLIGHT_COLOR
    val borderColor = if (isSelected) Color.Transparent else HIGHLIGHT_COLOR
    Box(
        modifier = modifier
            .height(40.dp)
            .clickable {
                onClick()
            }
            .clip(RoundedCornerShape(24.dp))
            .background(color = color)
            .border(width = 1.dp, color = borderColor, shape = RoundedCornerShape(24.dp))
    ) {
        MPText(
            title = text, style = TextStyle(color = textColor),
            modifier = Modifier
                .padding(4.dp)
                .align(Alignment.Center)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun MPPager(response: RecipeDetailResponse) {
    var isTab1Selected by remember { mutableStateOf(true) }
    var isTab2Selected by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0, initialPageOffsetFraction = 0f)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        MPTab(
            modifier = Modifier.weight(0.475f),
            text = StringConstants.translationOfWords("Ingredients"),
            isSelected = isTab1Selected
        ) {
            isTab1Selected = true
            isTab2Selected = false
            scope.launch {
                pagerState.animateScrollToPage(0, 0f)
            }
        }
        Spacer(modifier = Modifier.weight(0.05f))
        MPTab(
            modifier = Modifier.weight(0.475f),
            text = StringConstants.translationOfWords("Instructions"),
            isSelected = isTab2Selected
        ) {
            isTab1Selected = false
            isTab2Selected = true
            scope.launch {
                pagerState.animateScrollToPage(1, 0f)
            }
        }
    }
    HorizontalPager(
        pageCount = 2, state = pagerState,
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        AnimatedContent(
            targetState = pagerState,
            label = ""
        ) {
            when (it.currentPage) {
                0 -> {
                    IngredientComposable(response)
                }

                else -> {
                    InstructionsComposable(response)
                }
            }
        }
    }
}

@Composable
fun InstructionsComposable(response: RecipeDetailResponse) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MPTextBold(title = response.instructions.title)
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            MPText(title = StringConstants.translationOfWords("Prep: "))
            MPTextBold(
                title = response.instructions.prep.plus(StringConstants.translationOfWords("mins")),
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
            MPText(title = StringConstants.translationOfWords("Cook: "))
            MPTextBold(
                title = response.instructions.cookingTime.plus(
                    StringConstants.translationOfWords(
                        "mins"
                    )
                ), fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        response.instructions.steps.forEachIndexed { index, s ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                MPTextBold(
                    title = (index + 1).toString(),
                    style = TextStyle(color = HIGHLIGHT_COLOR)
                )
                Spacer(modifier = Modifier.width(8.dp))
                MPText(
                    title = response.instructions.steps[index],
                    style = TextStyle(color = Color.Black, fontSize = 17.sp)
                )
            }
        }
        Spacer(modifier = Modifier.height(90.dp))
    }
}

@Composable
fun IngredientComposable(response: RecipeDetailResponse) {
    Column {
        MPTextBold(title = "Quantities")
        Spacer(modifier = Modifier.height(16.dp))
        response.ingredients.quantities.toList().forEach {
            val titleArray = it.first.split(" ")
            var title = ""
            title = if (titleArray.size > 1) {
                title.plus(titleArray[0]).plus(StringConstants.translationOfWords(titleArray[1]))
            } else {
                titleArray[0]
            }
            Row() {
                MPTextBold(
                    title = title, modifier = Modifier.weight(0.3f),
                    style = TextStyle(color = Color.Black), fontSize = 16.sp
                )
                MPText(title = it.second, modifier = Modifier.weight(0.7f))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        response.ingredients.products?.forEach {
            SelectedRecipeProducts(it)
            Spacer(modifier = Modifier.height(8.dp))
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            MPText(
                title = StringConstants.translationOfWords("Total Items"),
                modifier = Modifier.weight(1f),
                style = TextStyle(color = Color.Black, fontSize = 17.sp)
            )
            MPText(
                title = response.ingredients.products?.size.toString(),
                style = TextStyle(color = Color.Black, fontSize = 17.sp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            MPTextBold(
                title = "Estimated Total", modifier = Modifier.weight(1f),
                style = TextStyle(color = Color.Black), fontSize = 16.sp
            )
            MPTextBold(
                title = response.ingredients.estimatedTotal,
                style = TextStyle(color = Color.Black), fontSize = 16.sp
            )
        }
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun RecipeProduct(product: Products.Product) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .height(70.dp)
        ) {
            AsyncImage(
                model = Utils.getImageRequest(product.imageUrl, LocalContext.current),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.25f)
            )
            Column(
                modifier = Modifier
                    .weight(0.75f)
                    .fillMaxHeight()
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    MPTextBold(
                        title = product.name.orEmpty(),
                        maxlines = 2,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp),
                        fontSize = 16.sp
                    )
                    MPTextBold(
                        title = product.price.orEmpty(),
                        fontSize = 16.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom
                ) {
                    MPText(
                        title = product.description.orEmpty(), modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp)
                    )
                    MPText(title = "Quantity ${product.quantity}")
                }
            }
        }
    }
}

@Composable
fun SelectedRecipeProducts(product: Products.Product) {
    Card(
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .height(70.dp)
        ) {
            AsyncImage(
                model = Utils.getImageRequest(product.imageUrl, LocalContext.current),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.25f)
            )
            Column(
                modifier = Modifier
                    .weight(0.75f)
                    .fillMaxHeight()
            ) {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    MPTextBold(
                        title = product.name.orEmpty(),
                        maxlines = 2,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp),
                        fontSize = 16.sp
                    )
                    MPTextBold(
                        title = product.price.orEmpty(),
                        fontSize = 16.sp
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom
                ) {
                    MPText(
                        title = product.description.orEmpty(), modifier = Modifier
                            .weight(1f)
                            .padding(start = 16.dp, end = 16.dp)
                    )
                    MPText(title = "Quantity ${product.quantity}")
                }
            }
        }
    }
}

@Composable
fun WishlistIcon() {
    val resource = painterResource(id = R.drawable.save)
    Box(
        modifier = Modifier
            .width(28.dp)
            .height(28.dp)
            .border(width = 1.dp, color = HIGHLIGHT_COLOR, shape = CircleShape)
    ) {
        Icon(
            painter = resource,
            contentDescription = "",
            tint = Color.Black,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun HorizontalFilterList(filters: List<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        items(filters.size) {
            MPText(
                title = filters[it],
                modifier = Modifier
                    .padding(4.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    )
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
                    .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                style = TextStyle(
                    color = HIGHLIGHT_COLOR,
                    fontSize = 16.sp
                ),
            )
        }
    }
}

@Composable
fun MPCost(cost: Int) {
    var bold = "₹"
    var normal = "₹₹"
    when (cost) {
        1 -> {
            bold = "₹"
            normal = "₹₹"
        }

        2 -> {
            bold = "₹₹"
            normal = "₹"
        }

        3 -> {
            bold = "₹₹₹"
            normal = ""
        }
    }
    Row(verticalAlignment = Alignment.Top) {
        MPTextBold(title = bold, fontSize = 18.sp)
        MPText(title = normal, style = TextStyle(color = Color.Black, fontSize = 18.sp))
    }
}

@Composable
fun MPFullWidthImage(image: String, height: Dp) {
    AsyncImage(
        model = Utils.getImageRequest(image, LocalContext.current),
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .height(height)
            .fillMaxWidth()
    )
}