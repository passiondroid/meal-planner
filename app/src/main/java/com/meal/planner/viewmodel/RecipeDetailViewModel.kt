package com.meal.planner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
}