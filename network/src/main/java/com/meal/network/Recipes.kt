package com.meal.network

import com.meal.network.model.Products
import com.meal.network.model.RecipeDetailResponse

object Recipes {

    fun getRecipe(id: Int, name: String, image: String): RecipeDetailResponse {
        val recipes = arrayListOf(
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "This refreshing drink is the perfect way to add a sweet, tropical spin to your drink pitcher.This easy lemonade...",
                serving = "4 ",
                prep = "5 ",
                cookingTime = "0 ",
                cost = 1,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "3 tbsp" to "Fresh lemon juice",
                        "1 cup" to "Mango medley juice blend",
                        "2 cups" to "Frozen mango pieces",
                        "1/2" to "Lemon",
                        "2 1/2 cups" to "Lemon flavour sparkling water"
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "910000558862",
                            cin = "3875253",
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "910002339446",
                            cin = "5384295"
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "910001488114",
                            cin = "4808682"
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "5 ",
                    cookingTime = "0 ",
                    steps = arrayListOf(
                        "Combine frozen mango juice in a blender. Blend until smooth. " +
                                "Pour through a strainer into a pitcher. Discard pulp.",
                        "Stir in sparkling lemon beverage and lemon juice. Refrigerate at " +
                                "least 30 minutes before serving.",
                        "Pour into four glasses filled with ice. Granish with a lemon wheel and more " +
                                "frozen mango, if desired."
                    )
                )
            ),
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "This is a quick and easy salad idea with a homemade vinaigrette drizzled over a mixture of lettuce, mandarin oranges, and almond slivers.",
                serving = "4 ",
                prep = "10 ",
                cookingTime = "10 ",
                cost = 1,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "3 tbsp" to "Canola oil",
                        "1/4 cup" to "Red wine vinegar",
                        "2 tbsp" to "White Sugar",
                        "1/2 tbsp" to "Salt",
                        "1/2 tbsp" to "Dry Mustard",
                        "1" to "Red leaf lettuce",
                        "1 can" to "Mandarin oranges",
                        "1/4 cup" to "Slivered almonds",
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "",
                            cin = ""
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "5 ",
                    cookingTime = "0 ",
                    steps = arrayListOf(
                        "Combine canola oil, vinegar, sugar, lemon juice, salt, and dry mustard in a jar with a lid. " +
                                "Shake until ingredients combine into a dressing.",
                        "Toss lettuce, oranges, and almonds together in a large mixing bowl. " +
                                "Drizzle dressing over the salad and toss to coat.",
                    )
                )
            ),
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "This Butternut Squash and Apple Soup is creamy and bursting with fall flavor! Hard to believe it’s totally vegan and made with only 8 ingredients.",
                serving = "4 ",
                prep = "10 ",
                cookingTime = "25 ",
                cost = 2,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "1 tbsp" to "Olive oil",
                        "1" to "Yellow onion, diced",
                        "2-3" to "Cloves of garlic, minced",
                        "1" to "Granny Smith apple, diced",
                        "1/2 tbsp" to "Chopped fresh rosemary",
                        "1 tbsp" to "finely chopped fresh sage",
                        "5-6 cups" to "Butternut squash, peeled and diced",
                        "3 cups" to "Vegetable broth",
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "",
                            cin = ""
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "10 ",
                    cookingTime = "25 ",
                    steps = arrayListOf(
                        "Bring a large soup pot to medium heat and add the oil (for oil-free add a splash of vegetable broth). " +
                                "Add the onion and apple, then sauté until the onion is translucent, 3 to 5 minutes",
                        "Add in the garlic, rosemary, sage, and a pinch of salt. Sauté for an additional 1 to 2 minutes, " +
                                "then add in the squash, coconut milk, and vegetable broth.",
                        "Raise the heat to high and bring the mixture to a boil, then reduce the heat to medium-low and simmer " +
                                "uncovered for 10 to 12 minutes, until the squash is fork-tender. Carefully use an immersion blender to " +
                                "blend the soup until smooth, or transfer to an upright blender and blend on high speed to do the same.",
                    )
                )
            ),
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "Apple Walnut Spinach Salad is a fresh continental dish which is prepared with green apples, apples, maraschino cherries, dates, walnuts, sour cream and mayonnaise. This recipe is is ideal as a side dish or an appetizer for kitty parties, game nights and buffets. You can serve this cold salad during summers to your cold ones. Team this easy-to-make and delicious delicacy with toasted garlic bread.",
                serving = "6 ",
                prep = "10 ",
                cookingTime = "10 ",
                cost = 1,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "3" to "Green apple",
                        "2" to "Medium apple",
                        "30" to "Maraschino cherry",
                        "1/2 cup" to "Walnuts",
                        "1/2 cup" to "Sour cream",
                        "1 1/2 tbsp" to "Lemon juice",
                        "1 can" to "Mandarin oranges",
                        "2 tbsp" to "Cranberries",
                        "100 gm" to "Spinach",
                        "1 tbsp" to "Cheddar cheese",
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "",
                            cin = ""
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "10 ",
                    cookingTime = "10 ",
                    steps = arrayListOf(
                        "Firstly, take 15 Red Maraschino and 15 Green Maraschino cherries in a bowl and keep them aside. " +
                                "Now, wash the apples, cranberries, spinach under running water.",
                        "Take a chopping board and chop the apples coarsely. Now, cut the cherries, cranberries into halves, " +
                                "chop the spinach too and keep the ingredients in separate bowls.",
                        "Now, pour lemon juice in the bowl of apples and mix well. Keep in the refrigerator for 15 minutes. " +
                                "Take the bowl out after 15 minutes and add sour cream and mayonnaise in the bowl and mix.",
                        "Coat the apples with sour cream and mayonnaise, cheddar cheese well so that each piece has sufficient amount " +
                                "of this mixture. Add dates, walnuts and cherries, cranberries and mix well again. Serve!"
                    )
                )
            ),
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "Asian Steak Salad. A healthy vegetable packed steak salad with an Asian Sesame Lemon Dressing. Ready in 15 minutes and perfect for dinner or lunch.",
                serving = "1 ",
                prep = "15 ",
                cookingTime = "10 ",
                cost = 1,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "1/3" to "Cucumber sliced",
                        "1/2" to "Yellow bell pepper diced",
                        "1/2" to "Orange bell pepper diced",
                        "6" to "Romaine lettuce leaves, chopped",
                        "1" to "Tomato, sliced",
                        "1" to "Marbled flank steak",
                        "2 tbsp" to "Extra virgin olive oil",
                        "1/2 tbsp" to "Garlic",
                        "1 tbsp" to "Sesame oil",
                        "2 tbsp" to "Maple syrup",
                        "1 tbsp" to "Mustard",
                        "1" to "Lemon juice",
                        "1/2 tbsp" to "Sesame seeds",
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "",
                            cin = ""
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "10 ",
                    cookingTime = "10 ",
                    steps = arrayListOf(
                        "Prepare your vegetables as listed above and place them into your serving bowl.",
                        "In a jar, add your ingredients for your dressing, seal it and shake until the ingredients are mixed well.",
                        "In a hot pan, add oil. Season your steak with salt on each side. Add it to the hot frying pan. Fry on each side for " +
                                "3 minutes over medium high heat. This will make the steak medium rare. If you prefer a more cooked steak, cook " +
                                "it for 5-6 minutes until well done.",
                        "Slice your steak into bite size pieces and top it onto your salad. Add the dressing and enjoy!"
                    )
                )
            ),
            RecipeDetailResponse(
                name = name,
                image = image,
                filters = arrayListOf(
                    "5 ingredients or less",
                    "All recipes",
                    "Budget Friendly",
                    "Drinks",
                    "Entertaining",
                    "No Cook",
                    "Snacks"
                ),
                description = "Fresh peas, asparagus and leeks - this winning trio makes an easy weekend lunch. Herbs are everywhere in spring, try planting a small herb garden so you’ll always have some on hand.",
                serving = "4 ",
                prep = "10 ",
                cookingTime = "20 ",
                cost = 2,
                ingredients = RecipeDetailResponse.Ingredients(
                    quantities = mutableMapOf(
                        "1" to "Leek - trimmed and white part thinly sliced",
                        "1" to "Clove of garlic - crushed",
                        "200 gm" to "Light Philadelphia spreadable cheese",
                        "1/2 cup" to "Low fat Tzatziki",
                        "3" to "Eggs",
                        "1/2 tbsp" to "Salt",
                        "1/2 tbsp" to "Pepper",
                        "1 bunch" to "Asparagus -woody ends trimmed and cut into 3 cm lengths",
                        "1/2 cup" to "Frozen or fresh peas",
                        "5 tbsp" to "Chopped parsley",
                        "2 tbsp" to "Chopped dill",
                        "1 tbsp" to "Pinenuts",
                        "2 sheets" to "Fat reduced puff pastry - thawed",
                    ),
                    products = listOf(
                        Products.Product(
                            name = "Mango Medley Juice Blend",
                            description = "Great Value",
                            price = "₹ 200",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/asr/00af5a4e-38b6-4baf-b425-846005ea766f.750ccada70d74492bfa89aed8c077d7c.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Great Value Frozen Mango Chunks",
                            description = "Great Value",
                            price = "₹ 300",
                            quantity = "1",
                            imageUrl = "https://i5.walmartimages.com/seo/Great-Value-Mango-Chunks-Frozen-48-oz_4a2facc5-09f7-4088-b57d-74b80284cf1a.57d2d101362ccab0b299d3279e34fb4d.jpeg",
                            productCode = "",
                            cin = ""
                        ),
                        Products.Product(
                            name = "Our Finest Natural Lemon Flavour Spring Water - Carbonated",
                            description = "Our Finest",
                            price = "₹ 250",
                            quantity = "1",
                            imageUrl = "https://groceries.morrisons.com/productImages/112/112022011_0_640x640.jpg?identifier=46d0773a327149aaac705c9f65d10a4b",
                            productCode = "",
                            cin = ""
                        ),
                    ),
                    totalItems = "3",
                    estimatedTotal = "₹ 750"
                ),
                instructions = RecipeDetailResponse.Instructions(
                    title = "Step-by-step instructions",
                    prep = "10 ",
                    cookingTime = "20 ",
                    steps = arrayListOf(
                        "Preheat oven to 180 C.",
                        "Line a rectangular fluted quiche dish with pastry cover with baking paper and fill with baking weights, " +
                                "rice or beans and blind bake for 15 minutes. This partially cooks the pastry whilst the weight " +
                                "prevents the pastry from rising in the middle.",
                        "Remove weights and set aside.",
                        "Heat a sprayed non stick fry pan over low medium heat and cook leeks for 8-10 minutes or until wilted. " +
                                "Add garlic and cook for a few minutes more.",
                        "Whisk together cream cheese, yoghurt, eggs, salt and pepper until just combined, stir through fresh herbs " +
                                "and pour ¾ of the cheese mixture into the tart case.",
                        "Scatter over leeks, asparagus and peas and dollop on the remaining cheese mixture and scatter the pine nuts over",
                        "Bake for 30-40 minutes or until filling has set.",
                        "To serve, cool slightly, scatter over the remaining fresh herbs and serve with a salad."
                    )
                )
            ),
        )
        return if (id <= 6) {
            recipes[id-1]
        } else {
            recipes[id-7]
        }
    }
}