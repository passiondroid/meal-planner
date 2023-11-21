package com.meal.planner.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meal.network.RecipeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeDetailViewModel(private val repository: RecipeRepository): ViewModel() {

    private val _recipeDetailLiveData = MutableLiveData<RecipeDetailPageState>()
    val recipeDetailLiveData: MutableLiveData<RecipeDetailPageState> = _recipeDetailLiveData
    private val _recipeDetailProductLiveData = MutableLiveData<RecipeDetailsProductPageState>()
    val recipeDetailProductLiveData: MutableLiveData<RecipeDetailsProductPageState> = _recipeDetailProductLiveData

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

//    fun getRecipeProducts(qty: String, name: String) {
//        viewModelScope.launch(Dispatchers.IO) {
//            try {
//                val response = repository.getRecipeDetailsFromRemote(qty,name)
//                _recipeDetailProductLiveData.postValue(RecipeDetailsProductPageState.Success(response))
//                if(response.isSuccessful){
//
//                }else{
//                    Log.d("TAG", "getRecipeProducts: "+response.errorBody())
//                }
//                Log.d("TAG", "getRecipeProducts: response from server is = ${response.body()?.records?.productRespToList}")
//            } catch (e: Exception) {
//                Log.d("TAG", "getRecipeProducts: exception from server is = $e")
//                e.printStackTrace()
//            }
//        }
//
//    }

}