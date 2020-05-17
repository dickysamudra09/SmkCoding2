package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.NewsApi.CoronaApi.CoronaPositifApiItem
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaRecoveredApiItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoronaStatus {
    @GET("confirmed")
    fun getCoronaStatusPo(): Call<List<CoronaPositifApiItem>>

    companion object {

        var BASE_URL = "https://api.kawalcorona.com/"

        fun create() : CoronaStatus {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CoronaStatus::class.java)

        }
    }
}