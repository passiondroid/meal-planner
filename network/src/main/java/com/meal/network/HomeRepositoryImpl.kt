package com.meal.network

import com.meal.network.api.MealPlannerApi
import com.meal.network.model.HomePageResponse
import kotlinx.coroutines.delay

class HomeRepositoryImpl(private val mealPlannerApi: MealPlannerApi) : HomeRepository {

    override suspend fun getHomePage(): HomePageResponse {
        delay(500)
        return HomePageResponse(categories = listOf(
            HomePageResponse.Category(1, "Popular Categories", listOf(
                HomePageResponse.SubCategory(1,"Budget Friendly","https://food.fnr.sndimg.com/content/dam/images/food/fullset/2013/10/7/0/FNK_Greek-Salad_s4x3.jpg.rend.hgtvcom.616.462.suffix/1383814482359.jpeg"),
                HomePageResponse.SubCategory(2,"Family Favourites","https://www.eatthis.com/wp-content/uploads/sites/4/2019/02/general-tso-chicken.jpg"),
                HomePageResponse.SubCategory(3,"Healthy Eating","https://staticg.sportskeeda.com/editor/2023/01/1e93b-16736210235829-1920.jpg"),
            )),
            HomePageResponse.Category(2, "Cooking Method", listOf(
                HomePageResponse.SubCategory(1,"Air Fryer","https://hips.hearstapps.com/hmg-prod/images/air-fryer-recipes-1641930428.jpeg?crop=0.668xw:1.00xh;0.197xw,0&resize=640:*"),
                HomePageResponse.SubCategory(2,"Bake","https://www.jessicagavin.com/wp-content/uploads/2018/12/baking-muffins-pan.jpg"),
                HomePageResponse.SubCategory(3,"Bbq And Grilling","https://hips.hearstapps.com/hmg-prod/images/gettyimages-750561559-1528900910.jpg"),
                HomePageResponse.SubCategory(4,"Blender","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxjyUyA8DpwWVPvMR-sbz9qqReM2FR2tk6sA&usqp=CAU"),
                HomePageResponse.SubCategory(5,"Instant Pot","https://assets.bonappetit.com/photos/5bfc60be81037b6cb7f6ac4b/1:1/w_2560%2Cc_limit/instant-pot-veggie-stock-1.jpg"),
            )),
            HomePageResponse.Category(3, "Cuisine", listOf(
                HomePageResponse.SubCategory(1,"Asian-Style","https://hips.hearstapps.com/hmg-prod/images/black-pepper-chicken2-1647635684.jpeg?crop=0.696xw:1.00xh;0.135xw,0&resize=640:*"),
                HomePageResponse.SubCategory(2,"Canadian-Style","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHVwa8Qrpu1W7uxaMNasq5Xv9G2eZKiTLZDQ&usqp=CAU"),
                HomePageResponse.SubCategory(3,"French-Style","https://theplanetd.com/images/Traditional-French-Food.jpg"),
                HomePageResponse.SubCategory(4,"Greek-Style","https://images.immediate.co.uk/production/volatile/sites/30/2020/08/greek-style-roast-fish-efd6bb8.jpg"),
                HomePageResponse.SubCategory(5,"Indian-Style","https://c.ndtvimg.com/2022-03/jcliv9dg_shahi-paneer_625x300_15_March_22.jpg?im=FaceCrop,algorithm=dnn,width=1200,height=886"),
            )),
            HomePageResponse.Category(4, "Difficulty", listOf(
                HomePageResponse.SubCategory(1,"15 Min Or Less","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8VhRpesQdOqj0Oyj9SWB3iBEprGo19F8QRw&usqp=CAU"),
                HomePageResponse.SubCategory(2,"30 Min Or Less","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkmrublOkLfZSBc8mphaw2vP0OpcfrzIoQ5g&usqp=CAU"),
                HomePageResponse.SubCategory(3,"5 Ingredients Or Less","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtdNBcQ7fPnMvSegguZzs0-9Ks2Ql90gnvrg&usqp=CAU"),
                HomePageResponse.SubCategory(4,"Quick And Easy Dinners","https://www.acouplecooks.com/wp-content/uploads/2021/03/Cheese-Tortellini-011.jpg"),
            )),
            HomePageResponse.Category(5, "Main Protein", listOf(
                HomePageResponse.SubCategory(1,"Beef","https://images.immediate.co.uk/production/volatile/sites/30/2020/08/roast-beef-recipes-536cd86.jpg"),
                HomePageResponse.SubCategory(2,"Chicken recipes","https://www.jocooks.com/wp-content/uploads/2019/07/garlic-and-paprika-chicken-1-14.jpg"),
                HomePageResponse.SubCategory(3,"Fish","https://c.ndtvimg.com/2021-02/gsq3frgg_fish-fry_625x300_10_February_21.jpg"),
                HomePageResponse.SubCategory(4,"Pork Recipes","https://fitfoodiefinds.com/wp-content/uploads/2021/02/sticky-pork-683x1024.jpg"),
                HomePageResponse.SubCategory(5,"Shrimp","https://sallysbakingaddiction.com/wp-content/uploads/2016/05/honey-garlic-shrimp-5.jpg"),
            )),
            HomePageResponse.Category(6, "Meal Type", listOf(
                HomePageResponse.SubCategory(1,"Appetizers","https://images-gmi-pmc.edge-generalmills.com/fca4b25f-5859-4048-974c-4ef02a0014ee.jpg"),
                HomePageResponse.SubCategory(2,"Breakfast","https://hips.hearstapps.com/hmg-prod/images/baked-eggs-and-zoodles-bundles1-1661458891.jpeg"),
                HomePageResponse.SubCategory(3,"Brunch","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiTXj3BwVSOfqU2h-68WfP_Ihym3AuR97Azjuhm2Ib7Aazwp7xSdrCPsx3BYRdGXCYQss&usqp=CAU"),
                HomePageResponse.SubCategory(4,"Dessert","https://images.immediate.co.uk/production/volatile/sites/30/2020/08/easy-chocolate-molten-cakes-37a25eb.jpg"),
                HomePageResponse.SubCategory(5,"Drinks","https://therecipecritic.com/wp-content/uploads/2023/05/lava_flow.jpg"),
            )),
        ))
    }
}