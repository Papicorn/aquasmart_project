package com.aquanusa.aquasmart.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitInstance {
    //    private const val BASE_URL = "http://192.168.100.99:3000/api/"
    private const val BASE_URL = "https://api1.aquasmart.my.id/api/"
//    private const val BASE_URL = "http://10.0.2.2:3000/api/"

    private val okHttpClient = OkHttpClient.Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    val api: YourApiService by lazy {
        retrofit.create(YourApiService::class.java)
    }
}