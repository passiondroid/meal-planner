package com.meal.core.network

import retrofit2.Retrofit

interface INetworkServiceCreator<T> {
    fun <S> createService(retrofit: Retrofit, serviceClass: Class<S>): S?
}