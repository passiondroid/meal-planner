package com.meal.core.constants

object Constants {

//    const val BASE_URL = "https://passiondroid.github.io/"
    const val BASE_URL = "https://www.google.com/"
    const val ANON_TOKEN = "Bearer abcd"
    private var selectedLanguage = "English (United States)"
    private val lock = Any()
    fun setAppLanguage(language:String){
        synchronized(lock) {
            this.selectedLanguage = language
        }
    }

    fun getAppLanguage():String{
        return selectedLanguage
    }

}