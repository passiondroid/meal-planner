package com.meal.core.constants

object StringConstants {
    private val spanishValues = HashMap<String, String>()
    private val africanValues = HashMap<String, String>()
    private val vietnameseValues = HashMap<String, String>()
    fun createSpanishMap() {
        spanishValues["serving"] = "servicio"
        spanishValues["Prep: "] = "Deberes: "
        spanishValues["Cook: "] = "Cocinar: "
        spanishValues["Cost: "] = "Cocinar: "
        spanishValues["tbsp"] = "cucharada"
        spanishValues["cups"] = "tazas"
        spanishValues["Total Items"] = "articulos totales"
        spanishValues["Estimated Total"] = "Total estimada"
        spanishValues["Ingredients"] = "Ingredientes"
        spanishValues["Instructions"] = "Instrucciones"
        spanishValues["Add to Meal Plan"] = "Agregar al plan de comidas"
        spanishValues["Add to Cart"] = "Añadir a la cesta"
        spanishValues["mins"] = "minutos"
        spanishValues["gm"] = "gm"
    }

    fun createArficanMap(){
        africanValues["serving"] = "dien"
        africanValues["Prep: "] = "Voorbereiding: "
        africanValues["Cook: "] = "kok: "
        africanValues["Cost: "] = "Koste: "
        africanValues["tbsp"] = "eetlepel"
        africanValues["cups"] = "koppies"
        africanValues["Total Items"] = "totaal Items"
        africanValues["Estimated Total"] = "geskatte totaal"
        africanValues["Ingredients"] = "Ingredients"
        africanValues["Instructions"] = "Instruksies"
        africanValues["Add to Meal Plan"] = "Voeg by Maaltydplan"
        africanValues["Add to Cart"] = "Voeg by mandjie"
        africanValues["mins"] = "minute"
        africanValues["gm"] = "gm"
    }

    fun createVietnameseMap(){
        vietnameseValues["serving"] = "phục vụ"
        vietnameseValues["Prep: "] = "chuẩn bị: "
        vietnameseValues["Cook: "] = "Đầu bếp: "
        vietnameseValues["Cost: "] = "Trị giá: "
        vietnameseValues["tbsp"] = "muỗng canh"
        vietnameseValues["cups"] = "cốc"
        vietnameseValues["Total Items"] = "Tổng số mặt hàng"
        vietnameseValues["Estimated Total"] = "Tổng số ước tính"
        vietnameseValues["Ingredients"] = "Thành phần"
        vietnameseValues["Instructions"] = "Hướng dẫn"
        vietnameseValues["Add to Meal Plan"] = "Thêm vào thực đơn bữa ăn"
        vietnameseValues["Add to Cart"] = "Thêm vào giỏ hàng"
        vietnameseValues["mins"] = "phút"
        vietnameseValues["gm"] = "gm"

    }
    fun translationOfWords(key: String): String {
        if (Constants.getAppLanguage() == "Spanish (Spain)") {
            return spanishValues[key].orEmpty()
        }else if(Constants.getAppLanguage() == "Afrikaans"){
            return africanValues[key].orEmpty()
        }else if(Constants.getAppLanguage() == "Vietnamese"){
            return vietnameseValues[key].orEmpty()
        }
        return key
    }
}