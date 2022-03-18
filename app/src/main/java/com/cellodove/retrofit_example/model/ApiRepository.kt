package com.cellodove.retrofit_example.model

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiRepository {
    private fun getRetrofit() : Retrofit{
        val baseUrl = "https://jsonplaceholder.typicode.com/"

        return Retrofit.Builder().baseUrl(baseUrl).client(
            OkHttpClient.Builder().apply {
                connectTimeout(30, TimeUnit.SECONDS)
                writeTimeout(30, TimeUnit.SECONDS)
                readTimeout(30, TimeUnit.SECONDS)
                addInterceptor(HttpLoggingInterceptor { message ->
                    Log.e("OkHttp", message)
                }.apply { level = HttpLoggingInterceptor.Level.BODY })
            }.build()).addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getCartApi(): ApiService {
        return getRetrofit().create(ApiService::class.java)
    }
}