package com.meal.planner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meal.network.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeCollectionViewModel(private val repository: RecipeRepository): ViewModel() {

    private val _recipeCollectionPageLiveData = MutableLiveData<RecipeCollectionPageState>()
    val recipeCollectionPageLiveData: MutableLiveData<RecipeCollectionPageState> = _recipeCollectionPageLiveData

    fun getRecipeCollectionPage() {
        _recipeCollectionPageLiveData.postValue(RecipeCollectionPageState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getRecipeCollections()
                _recipeCollectionPageLiveData.postValue(RecipeCollectionPageState.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}