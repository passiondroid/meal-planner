package com.meal.planner.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.facebook.flipper.plugins.uidebugger.LogTag
import com.meal.network.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.cos

class RecipeDetailViewModel(private val repository: RecipeRepository): ViewModel() {

    private val _recipeDetailLiveData = MutableLiveData<RecipeDetailPageState>()
    val recipeDetailLiveData: MutableLiveData<RecipeDetailPageState> = _recipeDetailLiveData

    fun getRecipeDetails(recipeId: Int, name: String, image: String) {
        _recipeDetailLiveData.postValue(RecipeDetailPageState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getRecipeDetails(recipeId, name, image)
                _recipeDetailLiveData.postValue(RecipeDetailPageState.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    fun getRecipeProducts(qty: String, name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getRecipeDetailsFromRemote(qty,name)
                Log.d("TAG", "getRecipeProducts: response from server is = $response")
            } catch (e: Exception) {
                Log.d("TAG", "getRecipeProducts: exception from server is = $e")
                e.printStackTrace()
            }
        }

    }

}