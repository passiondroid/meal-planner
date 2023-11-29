package com.meal.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDetailResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("filters")
    val filters: List<String>,
    @SerializedName("image")
    val image: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("serving")
    val serving: String,
    @SerializedName("prep")
    val prep: String,
    @SerializedName("cooking_time")
    val cookingTime: String,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("ingredients")
    val ingredients: Ingredients,
    @SerializedName("instructions")
    val instructions: Instructions,
) {
    data class Ingredients(
        @SerializedName("quantities")
        val quantities: Map<String, String>,
        @SerializedName("product")
        var products: List<Products.Product>? = emptyList(),
        @SerializedName("total_items")
        val totalItems: String,
        @SerializedName("estimated_total")
        val estimatedTotal: String,
    )

    data class Instructions(
        @SerializedName("title")
        val title: String,
        @SerializedName("prep")
        val prep: String,
        @SerializedName("cooking-time")
        val cookingTime: String,
        @SerializedName("steps")
        val steps: List<String>,
    )
}
//data class Product(
//    @SerializedName("title")
//    val title: String,
//    @SerializedName("sub_title")
//    val subTitle: String,
//    @SerializedName("price")
//    val price: String,
//    @SerializedName("quantity")
//    val quantity: String,
//    @SerializedName("image")
//    val image: String,
//    @SerializedName("skuId")
//    val skuId: String,
//    @SerializedName("cin")
//    val cin: String,
//)

data class FetchProducts(
    @SerializedName("id")
    val id:String,
    @SerializedName("record")
    val records: Records,
    @SerializedName("metadata")
    val metadata: Metadata

)

data class Metadata( @SerializedName("name")
                     val name: String,
                     @SerializedName("readCountRemaining")
                     val readCountRemaining: Int,
                     @SerializedName("timeToExpire")
                    val timeToExpire:Double,
                     @SerializedName("createdAt")
                     val createdAt:String
    )

data class Records(  @SerializedName("products")
                     val productRespToList:List<ProductRespTO>)
data class ProductRespTO(
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("quantity")
    val quantity: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("cin")
    val cin: String
) {

//    fun toProduct(): Product {
//        return Product(
//            title = this.name,
//            subTitle = this.description,
//            price = this.price,
//            quantity = this.quantity,
//            image = this.imageUrl,
//            cin = this.cin,
//            skuId = this.productCode
//        )
//    }
}


