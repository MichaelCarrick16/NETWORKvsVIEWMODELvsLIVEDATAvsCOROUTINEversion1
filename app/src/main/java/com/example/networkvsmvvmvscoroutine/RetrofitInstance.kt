package com.example.networkvsmvvmvscoroutine

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
    }

     val api : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}