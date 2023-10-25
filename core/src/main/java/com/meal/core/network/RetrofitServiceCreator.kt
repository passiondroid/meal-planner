package com.meal.core.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceCreator : INetworkServiceCreator<Retrofit> {
    private fun <S> create(networkLib: Retrofit?, serviceClass: Class<S>): S? {
        return networkLib?.create(serviceClass)
    }

    fun getRetrofit(url: String, okHttpClient: OkHttpClient?): Retrofit {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())

        okHttpClient?.let {
            retrofitBuilder.client(okHttpClient)
        }

        return retrofitBuilder.build()
    }

    /**
     * creates retrofit service
     */
    override fun <S> createService(retrofit: Retrofit, serviceClass: Class<S>): S? {
        return create(retrofit, serviceClass)
    }
}