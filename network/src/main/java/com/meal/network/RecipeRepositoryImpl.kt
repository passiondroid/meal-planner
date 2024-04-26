package com.meal.network

import android.util.Log
import com.google.ai.client.generativeai.GenerativeModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.meal.core.constants.Constants
import com.meal.network.api.MealPlannerApi
import com.meal.network.model.ProductRequestTO
import com.meal.network.model.Products
import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse
import com.meal.network.model.TranslatedRespone
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(
    private val mealPlannerApi: MealPlannerApi,
    private val generativeModel: GenerativeModel
) : RecipeRepository {

    override suspend fun getRecipeCollections(): RecipeCollectionResponse {
        val response = getRecipeCollection()
        try {
            if (Constants.getAppLanguage() == "English (United States)") {
                delay(500)
                return response
            } else {
                val titleList = arrayListOf<String>()
                response.filters.forEach {
                    titleList.add(it.name)
                }
                val geminiResponse =
                    generativeModel.generateContent(
                        GenAIUtil.getPrompt(
                            Constants.getAppLanguage(),
                            titleList
                        )
                    )
                val responseAI = geminiResponse.text
                FileLogger.log("geminiResponse for filters $responseAI")
                val typeToken = object : TypeToken<List<TranslatedRespone>>() {}.type
                val translatedResponse =
                    Gson().fromJson<List<TranslatedRespone>>(responseAI, typeToken)
                response.filters.forEachIndexed { index, filter ->
                    // response.filters[index].id = index
                    response.filters[index].name =
                        translatedResponse[index].translatedText ?: response.filters[index].name
                }

                val recipeItemList = arrayListOf<String>()
                response.recipeItems.forEach {
                    recipeItemList.add(it.name)
                }
                val geminiSubRecipeTitlesResp =
                    generativeModel.generateContent(
                        GenAIUtil.getPrompt(
                            Constants.getAppLanguage(),
                            recipeItemList
                        )
                    )
                val subRecipeTitleRespAI = geminiSubRecipeTitlesResp.text
                FileLogger.log("geminiResponse for recipe collection items $subRecipeTitleRespAI")
                val subTitleTypeToken = object : TypeToken<List<TranslatedRespone>>() {}.type
                val transaltedTitleResp =
                    Gson().fromJson<List<TranslatedRespone>>(
                        subRecipeTitleRespAI,
                        subTitleTypeToken
                    )
                response.recipeItems.forEachIndexed { index, recipeItem ->
                    response.recipeItems[index].name =
                        transaltedTitleResp[index].translatedText
                            ?: response.recipeItems[index].name
                }
                return response
            }
        }catch (ex:Exception){
            Log.d("====", "getRecipeCollections: exception caught ${ex.cause}")
        }
        return response
    }

    private fun getRecipeCollection(): RecipeCollectionResponse {
        return RecipeCollectionResponse(
            filters = listOf(
                RecipeCollectionResponse.Filter(1, "All Recipes"),
                RecipeCollectionResponse.Filter(2, "15 min or less"),
                RecipeCollectionResponse.Filter(3, "30 min or less"),
                RecipeCollectionResponse.Filter(4, "5 ingredients or less"),
                RecipeCollectionResponse.Filter(5, "Appetizers"),
                RecipeCollectionResponse.Filter(6, "Asian-style"),
                RecipeCollectionResponse.Filter(7, "BBQ and Grilling"),
                RecipeCollectionResponse.Filter(8, "Bacon"),
                RecipeCollectionResponse.Filter(9, "Bake"),
                RecipeCollectionResponse.Filter(10, "Beans"),
                RecipeCollectionResponse.Filter(11, "Beef"),
                RecipeCollectionResponse.Filter(12, "Birthday"),
                RecipeCollectionResponse.Filter(13, "Blender"),
                RecipeCollectionResponse.Filter(14, "Breads"),
                RecipeCollectionResponse.Filter(15, "Breakfast"),
                RecipeCollectionResponse.Filter(16, "Broccoli"),
                RecipeCollectionResponse.Filter(17, "Brunch"),
                RecipeCollectionResponse.Filter(18, "Budget Friendly"),
                RecipeCollectionResponse.Filter(19, "Cake"),
                RecipeCollectionResponse.Filter(20, "Casseroles and Gratins"),
                RecipeCollectionResponse.Filter(21, "Cheese"),
                RecipeCollectionResponse.Filter(22, "Chicken Recipes"),
                RecipeCollectionResponse.Filter(23, "Chocolate"),
                RecipeCollectionResponse.Filter(24, "Christmas"),
                RecipeCollectionResponse.Filter(25, "Cobblers and Crumbles"),
                RecipeCollectionResponse.Filter(26, "Cocktails"),
                RecipeCollectionResponse.Filter(27, "Cookies"),
                RecipeCollectionResponse.Filter(28, "Dessert"),
                RecipeCollectionResponse.Filter(29, "Dip"),
                RecipeCollectionResponse.Filter(30, "Drinks"),
                RecipeCollectionResponse.Filter(31, "Easter Recipes"),
                RecipeCollectionResponse.Filter(32, "Egg"),
                RecipeCollectionResponse.Filter(33, "Entertaining"),
                RecipeCollectionResponse.Filter(34, "Family Favourites"),
                RecipeCollectionResponse.Filter(35, "Fish"),
                RecipeCollectionResponse.Filter(36, "Freezer"),
                RecipeCollectionResponse.Filter(37, "Fruits"),
                RecipeCollectionResponse.Filter(38, "Grains"),
                RecipeCollectionResponse.Filter(39, "Haddock"),
                RecipeCollectionResponse.Filter(40, "Half Your Plate"),
                RecipeCollectionResponse.Filter(41, "Healthy Eating"),
                RecipeCollectionResponse.Filter(42, "Ice Cream"),
                RecipeCollectionResponse.Filter(43, "Indian-style"),
                RecipeCollectionResponse.Filter(44, "Italian-style"),
                RecipeCollectionResponse.Filter(45, "Jams and Jellies"),
                RecipeCollectionResponse.Filter(46, "Japanese-style"),
                RecipeCollectionResponse.Filter(47, "Kraft Fresh and Easy"),
                RecipeCollectionResponse.Filter(48, "Main Meal"),
                RecipeCollectionResponse.Filter(49, "Mexican-style"),
                RecipeCollectionResponse.Filter(45, "Muffins"),
            ),
            recipeItems = listOf(
                RecipeCollectionResponse.RecipeItem(
                    id = 1,
                    name = "Sparkling Mango Lemonade Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPj6Dy4zKIY28GpzfGZq_JF3Q4scnjHeahaw&usqp=CAU",
                    filterIds = listOf(1, 4, 7, 10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 2,
                    name = "Almond & Orange Salad Recipe",
                    image = "https://anoregoncottage.com/wp-content/uploads/2010/03/Orange-Almond-Salad_650.jpg",
                    filterIds = listOf(1, 2, 3, 5, 11)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 3,
                    name = "Apple & Butternut Squash Soup Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDFmmMHGinfsnhNTInRNIfLYz5KDFUL9uiLw&usqp=CAU",
                    filterIds = listOf(1, 5, 7, 6)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 4,
                    name = "Apple & Walnut Spinach Salad Recipe",
                    image = "https://riseshinecook.ca/wp-content/uploads/2020/10/Walnut-Spinach-Salad-2.jpg",
                    filterIds = listOf(1, 2, 7, 10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 5,
                    name = "Asian Steak Salad Recipe",
                    image = "https://nomnompaleo.com/wp-content/uploads/2019/12/800-IG-Asian-Steak-Salad-Hero-03.jpg",
                    filterIds = listOf(1, 3, 4, 5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 6,
                    name = "Asparagus and Leek Tart Recipe",
                    image = "https://www.lifewithoutmeat.com/wp-content/uploads/2020/04/leek-puff-pastry-web4.jpg",
                    filterIds = listOf(1, 3, 4, 5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 7,
                    name = "Sparkling Mango Lemonade Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPj6Dy4zKIY28GpzfGZq_JF3Q4scnjHeahaw&usqp=CAU",
                    filterIds = listOf(1, 4, 7, 10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 8,
                    name = "Almond & Orange Salad Recipe",
                    image = "https://anoregoncottage.com/wp-content/uploads/2010/03/Orange-Almond-Salad_650.jpg",
                    filterIds = listOf(1, 2, 3, 5, 11)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 9,
                    name = "Apple & Butternut Squash Soup Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDFmmMHGinfsnhNTInRNIfLYz5KDFUL9uiLw&usqp=CAU",
                    filterIds = listOf(1, 5, 7, 6)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 10,
                    name = "Apple & Walnut Spinach Salad Recipe",
                    image = "https://riseshinecook.ca/wp-content/uploads/2020/10/Walnut-Spinach-Salad-2.jpg",
                    filterIds = listOf(1, 2, 7, 10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 11,
                    name = "Asian Steak Salad Recipe",
                    image = "https://nomnompaleo.com/wp-content/uploads/2019/12/800-IG-Asian-Steak-Salad-Hero-03.jpg",
                    filterIds = listOf(1, 3, 4, 5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 12,
                    name = "Asparagus and Leek Tart Recipe",
                    image = "https://www.lifewithoutmeat.com/wp-content/uploads/2020/04/leek-puff-pastry-web4.jpg",
                    filterIds = listOf(1, 3, 4, 5)
                ),
            )
        )
    }

    override suspend fun getRecipeDetails(
        id: Int,
        name: String,
        image: String
    ): RecipeDetailResponse {
        return recipeDetails(id, name, image)
    }

    private suspend fun recipeDetails(id: Int, name: String, image: String): RecipeDetailResponse {
        val recipe = Recipes.getRecipe(id, name, image)
        try {

            if (Constants.getAppLanguage() == "English (United States)") {
                return recipe
            }
            val recipeDetailFilters = arrayListOf<String>()
            recipe.filters.forEach {
                recipeDetailFilters.add(it)
            }
            val translatedFilterResponse = getTranslatedResponse(recipeDetailFilters)
            recipe.filters.forEachIndexed { idx, s ->
                recipe.filters[idx] =
                    translatedFilterResponse?.get(idx)?.translatedText ?: recipe.filters[idx]
            }
            recipeDetailFilters.clear()
            recipeDetailFilters.add(recipe.description)
            val translatedRecipeDescription = getTranslatedResponse(recipeDetailFilters)
            recipe.description = translatedRecipeDescription?.get(0)?.translatedText
                ?: recipe.description
            recipeDetailFilters.clear()
            val ingrediantsKeys = arrayListOf<String>()
            recipe.ingredients.quantities.forEach {
                recipeDetailFilters.add(it.value)
                ingrediantsKeys.add(it.key)
            }
            val translatedIngredients = getTranslatedResponse(recipeDetailFilters)
            ingrediantsKeys.forEachIndexed { index, s ->
                val translatedValue = translatedIngredients?.get(index)?.translatedText
                    ?: recipe.ingredients.quantities.getValue(s)
                recipe.ingredients.quantities[s] = translatedValue
            }
            val translatedInstructions = getTranslatedResponse(ArrayList(recipe.instructions.steps))
            Log.d(
                "====",
                "recipeDetails: translated inst size is = ${translatedInstructions?.size}"
            )
            Log.d(
                "====",
                "recipeDetails: translated inst list is = ${translatedInstructions.toString()}"
            )
            Log.d("====", "recipeDetails: orig inst size is = ${recipe.instructions.steps.size}")

            recipe.instructions.steps.forEachIndexed { index, s ->
                recipe.instructions.steps[index] =
                    translatedInstructions?.get(index)?.translatedText
                        ?: recipe.instructions.steps[index]
            }
        }catch (ex:Exception){
            Log.d("====", "recipeDetails: exception occured in recipeDetails() ${ex.cause}")
        }
        return recipe
    }

    private suspend fun getTranslatedResponse(textList: ArrayList<String>): List<TranslatedRespone>? {
        val geminiResponse =
            generativeModel.generateContent(
                GenAIUtil.getPrompt(
                    Constants.getAppLanguage(),
                    textList
                )
            )
        val responseAI = geminiResponse.text
        FileLogger.log("translated gemini response $responseAI")
        val typeToken = object : TypeToken<List<TranslatedRespone>>() {}.type
        return Gson().fromJson(responseAI, typeToken)
    }

    private suspend fun getRecipeDetailFromNW(productRequestTO: ProductRequestTO): List<Products.Product>? {
        try {
            val productList = mealPlannerApi.getRecipeDetails(productRequestTO)
            return productList.products
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}