package com.meal.network

import com.meal.network.api.MealPlannerApi
import com.meal.network.model.IngrediantsTO
import com.meal.network.model.ProductRequestTO
import com.meal.network.model.Products
import com.meal.network.model.RecipeCollectionResponse
import com.meal.network.model.RecipeDetailResponse
import kotlinx.coroutines.delay

class RecipeRepositoryImpl(private val mealPlannerApi: MealPlannerApi) : RecipeRepository {

    override suspend fun getRecipeCollections(): RecipeCollectionResponse {
        delay(500)
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
                    filterIds = listOf(1,4,7,10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 2,
                    name = "Almond & Orange Salad Recipe",
                    image = "https://anoregoncottage.com/wp-content/uploads/2010/03/Orange-Almond-Salad_650.jpg",
                    filterIds = listOf(1,2,3,5,11)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 3,
                    name = "Apple & Butternut Squash Soup Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDFmmMHGinfsnhNTInRNIfLYz5KDFUL9uiLw&usqp=CAU",
                    filterIds = listOf(1,5,7,6)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 4,
                    name = "Apple & Walnut Spinach Salad Recipe",
                    image = "https://riseshinecook.ca/wp-content/uploads/2020/10/Walnut-Spinach-Salad-2.jpg",
                    filterIds = listOf(1,2,7,10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 5,
                    name = "Asian Steak Salad Recipe",
                    image = "https://nomnompaleo.com/wp-content/uploads/2019/12/800-IG-Asian-Steak-Salad-Hero-03.jpg",
                    filterIds = listOf(1,3,4,5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 6,
                    name = "Asparagus and Leek Tart Recipe",
                    image = "https://www.lifewithoutmeat.com/wp-content/uploads/2020/04/leek-puff-pastry-web4.jpg",
                    filterIds = listOf(1,3,4,5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 7,
                    name = "Sparkling Mango Lemonade Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPj6Dy4zKIY28GpzfGZq_JF3Q4scnjHeahaw&usqp=CAU",
                    filterIds = listOf(1,4,7,10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 8,
                    name = "Almond & Orange Salad Recipe",
                    image = "https://anoregoncottage.com/wp-content/uploads/2010/03/Orange-Almond-Salad_650.jpg",
                    filterIds = listOf(1,2,3,5,11)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 9,
                    name = "Apple & Butternut Squash Soup Recipe",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTDFmmMHGinfsnhNTInRNIfLYz5KDFUL9uiLw&usqp=CAU",
                    filterIds = listOf(1,5,7,6)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 10,
                    name = "Apple & Walnut Spinach Salad Recipe",
                    image = "https://riseshinecook.ca/wp-content/uploads/2020/10/Walnut-Spinach-Salad-2.jpg",
                    filterIds = listOf(1,2,7,10)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 11,
                    name = "Asian Steak Salad Recipe",
                    image = "https://nomnompaleo.com/wp-content/uploads/2019/12/800-IG-Asian-Steak-Salad-Hero-03.jpg",
                    filterIds = listOf(1,3,4,5)
                ),
                RecipeCollectionResponse.RecipeItem(
                    id = 12,
                    name = "Asparagus and Leek Tart Recipe",
                    image = "https://www.lifewithoutmeat.com/wp-content/uploads/2020/04/leek-puff-pastry-web4.jpg",
                    filterIds = listOf(1,3,4,5)
                ),
            )
        )
    }

    override suspend fun getRecipeDetails(id: Int, name: String, image: String): RecipeDetailResponse {
        return recipeDetails(id, name, image)
    }

    private suspend fun recipeDetails(id: Int, name: String, image: String): RecipeDetailResponse {
        val recipe = Recipes.getRecipe(id, name, image)
        val ingredients = recipe.ingredients.quantities.map {
            IngrediantsTO(it.key,it.value)
        }.toList()
        val products = getRecipeDetailFromNW(ProductRequestTO(ingredients))
        recipe.ingredients.products = products
        return recipe
    }

    private suspend fun getRecipeDetailFromNW(productRequestTO: ProductRequestTO) : List<Products.Product>? {
        try {
            val productList = mealPlannerApi.getRecipeDetails()
            return productList.products
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}