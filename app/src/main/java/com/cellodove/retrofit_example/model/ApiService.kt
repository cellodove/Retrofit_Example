package com.cellodove.retrofit_example.model

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("/posts/{post}")
    suspend fun authSignUp(@Path("post") post : String): ApiResponse
}