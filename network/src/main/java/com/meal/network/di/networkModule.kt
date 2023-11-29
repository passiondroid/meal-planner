package com.meal.network.di

import com.facebook.flipper.plugins.network.BuildConfig
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.meal.core.constants.Constants.BASE_URL
import com.meal.core.network.RetrofitServiceCreator
import com.meal.network.HomeRepository
import com.meal.network.HomeRepositoryImpl
import com.meal.network.RecipeRepository
import com.meal.network.RecipeRepositoryImpl
import com.meal.network.api.MealPlannerApi
import com.meal.network.interceptor.RequestTokenInterceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit

val networkModule = module {

    single { NetworkFlipperPlugin()  }
    single<OkHttpClient> {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(RequestTokenInterceptor())
        builder.addNetworkInterceptor(FlipperOkhttpInterceptor(get()))
        builder.build()
    }

    single { RetrofitServiceCreator() }
    single {
        get<RetrofitServiceCreator>().getRetrofit(
        url = BASE_URL,
        get()
    ) }

    single<MealPlannerApi?> {
        RetrofitServiceCreator().createService(
            get(),
            MealPlannerApi::class.java
        )
    }

    single<HomeRepository> { HomeRepositoryImpl(get()) }
    single<RecipeRepository> { RecipeRepositoryImpl(get()) }
}