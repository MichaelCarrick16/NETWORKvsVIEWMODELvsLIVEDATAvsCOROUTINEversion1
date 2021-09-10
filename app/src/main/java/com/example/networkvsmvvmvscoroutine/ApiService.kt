package com.example.networkvsmvvmvscoroutine

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("photos/1")
    fun getImage() : Call<Image>
}