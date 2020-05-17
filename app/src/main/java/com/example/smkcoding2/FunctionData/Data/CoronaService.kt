package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import retrofit2.Call
import retrofit2.http.GET

interface CoronaService {
    @GET("confirmed")
    fun getCorona():Call<List<CoronaApiItem>>
}

