package com.meal.planner.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meal.network.HomeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository): ViewModel() {

    private val _homePageLiveData = MutableLiveData<HomePageState>()
    val homePageLiveData: MutableLiveData<HomePageState> = _homePageLiveData

    fun getHomePage() {
        _homePageLiveData.postValue(HomePageState.Loading)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = repository.getHomePage()
                _homePageLiveData.postValue(HomePageState.Success(response))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}