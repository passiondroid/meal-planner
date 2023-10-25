package com.meal.planner.di

import com.meal.planner.viewmodel.HomeViewModel
import com.meal.planner.viewmodel.RecipeCollectionViewModel
import com.meal.planner.viewmodel.RecipeDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { RecipeCollectionViewModel(get()) }
    viewModel { RecipeDetailViewModel(get()) }
}