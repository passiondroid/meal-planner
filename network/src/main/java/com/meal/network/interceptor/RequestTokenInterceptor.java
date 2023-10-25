package com.meal.network.interceptor;

import com.meal.core.constants.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class RequestTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request newRequest;

        try {
            newRequest = request.newBuilder()
                    .addHeader("Authorization", Constants.ANON_TOKEN)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return chain.proceed(request);
        }

        return chain.proceed(newRequest);
    }
}