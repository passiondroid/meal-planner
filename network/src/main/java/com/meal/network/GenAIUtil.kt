package com.meal.network

import android.content.Context
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object GenAIUtil {

    fun getPrompt(language: String, textList: List<String>): String {
        println("============= textList $textList")
        println("============= lanugage in util $language")
        return """Given list of sample texts - 
            
            $textList 
            
            Translate the texts to this specific ISO language code - $language
            And always return the response in below json format -

                            [
                             {
                                    "originalText": "value",
                                    "translatedText": "value"
                             },
                             {
                                    "originalText": "value",
                                    "translatedText": "value"
                             }
                            ]
        """.trimIndent()


    }


}