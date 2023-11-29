package com.meal.planner.recipedetail

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.meal.design.ui.AnnotatedMPText
import com.meal.design.ui.MPCost
import com.meal.design.ui.HorizontalFilterList
import com.meal.design.ui.MPButton
import com.meal.design.ui.MPFullWidthImage
import com.meal.design.ui.MPPager
import com.meal.design.ui.MPText
import com.meal.design.ui.MPTextBold
import com.meal.design.ui.Utils
import com.meal.design.ui.WishlistIcon
import com.meal.network.model.FetchProducts
import com.meal.network.model.ProductRespTO
import com.meal.network.model.RecipeDetailResponse
import com.meal.planner.viewmodel.RecipeDetailPageState
import com.meal.planner.viewmodel.RecipeDetailViewModel
import com.meal.planner.viewmodel.RecipeDetailsProductPageState
import retrofit2.Response

@Composable
fun RecipeDetailScreen(viewModel: RecipeDetailViewModel, context: FragmentActivity) {
    val recipeDetailPageState = viewModel.recipeDetailLiveData.observeAsState()
//    val recipeDetailsProductPageState = viewModel.recipeDetailProductLiveData.observeAsState()

    var response : RecipeDetailResponse? = null
    if ((recipeDetailPageState.value is RecipeDetailPageState.Error).not() && recipeDetailPageState.value != null) {
        when (recipeDetailPageState.value) {
            is RecipeDetailPageState.Loading -> {
                Loading()
            }

            is RecipeDetailPageState.Success -> {
//                response =
//                    (recipeDetailPageState.value as RecipeDetailPageState.Success).response
                val productListResponse =
                    (recipeDetailPageState.value as RecipeDetailPageState.Success).response
                RecipeDetailContent(productListResponse, context)

            }

            else -> {
                Loading()
            }
        }
    } else {
        //TODO:Show error screen
    }

//    if ((recipeDetailsProductPageState.value is RecipeDetailsProductPageState.Error).not() && recipeDetailsProductPageState.value != null) {
//        when (recipeDetailsProductPageState.value) {
//            is RecipeDetailsProductPageState.Loading -> {
//                Loading()
//            }
//
//            is RecipeDetailsProductPageState.Success -> {
//               val productListResponse =
//                    (recipeDetailsProductPageState.value as RecipeDetailsProductPageState.Success).response
//                RecipeDetailContent(response!!, context,productListResponse)
//            }
//
//            else -> {
//                Loading()
//            }
//        }
//    } else {
//        //TODO:Show error screen
//    }
}

@Composable
fun RecipeDetailContent(
    response: RecipeDetailResponse,
    context: FragmentActivity,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box() {
                MPFullWidthImage(response.image, 300.dp)
                Box(
                    modifier = Modifier
                        .height(100.dp)
                        .fillMaxWidth()
                        .background(Utils.REVERSE_GRADIENT)
                )
                Column {
                    TopBar(response.name)
                    Spacer(modifier = Modifier.height(8.dp))
                    HorizontalFilterList(response.filters)
                }
            }
            Column {
                Card(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 230.dp, end = 16.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = CardDefaults.cardColors(Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        MPText(
                            title = response.description, style = TextStyle(
                                fontSize = 17.sp,
                                color = Color.Black
                            )
                        )
                        Spacer(modifier = Modifier.height(30.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            MPText(title = response.serving)
                            WishlistIcon()
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            AnnotatedMPText(title = "Prep: ", boldTitle = response.prep)
                            AnnotatedMPText(title = "Cook: ", boldTitle = response.cookingTime)
                            Row {
                                MPText(title = "Cost: ")
                                MPCost(response.cost)
                            }
                        }
                    }
                }
                MPPager(response)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            MPButton("Add to Meal Plan", modifier = Modifier.weight(0.45f)) {

            }
            Spacer(modifier = Modifier.weight(0.1f))
            MPButton("Add to       Cart", modifier = Modifier.weight(0.45f), onClick = {
                var skuCinIds = ""
                response.ingredients.products?.let {
                    for (productList in it) {
                        skuCinIds += productList.productCode.plus(":").plus(productList.cin).plus(",")
                    }
                    skuCinIds = skuCinIds.dropLast(1);
                    val intent = Intent().apply {
                        action = "com.asda.android.ADD_TO_CART"
                        putExtra(Intent.EXTRA_TEXT, skuCinIds)
                        type = "text/plain"
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    context.startActivity(intent)
                }
            })
        }
    }
}

@Composable
fun TopBar(title: String) {
    val activity = (LocalContext.current as Activity)
    Row(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
    ) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = "Back",
            tint = Color.White,
            modifier = Modifier.clickable { activity.finish() }
        )
        Spacer(modifier = Modifier.width(8.dp))
        MPTextBold(title = title, style = TextStyle(color = Color.White))
    }
}

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(48.dp)
                .background(color = Color.White, shape = CircleShape),
            strokeWidth = 2.dp,
            color = Color.Blue // You can customize the color
        )
    }
}