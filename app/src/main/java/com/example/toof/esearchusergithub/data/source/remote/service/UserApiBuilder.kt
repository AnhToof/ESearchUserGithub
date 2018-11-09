package com.example.toof.esearchusergithub.data.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class UserApiBuilder {

    companion object {
        private val BASE_URL = "https://api.github.com"

        private val mOkhttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(false)

        private val mRetrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(mOkhttpClient.build())
            .build()

        fun create(): UserApiService = mRetrofit.create(UserApiService::class.java)
    }
}
