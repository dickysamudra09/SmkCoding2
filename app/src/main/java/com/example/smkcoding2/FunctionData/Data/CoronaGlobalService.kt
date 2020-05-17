package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.NewsApi.CoronaApi.CoronaGlobalApiItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoronaGlobalService {

    @GET("confirmed")
    fun getCoronaGlobal(): Call<List<CoronaGlobalApiItem>>

    companion object {

        var BASE_URL = "https://covid19.mathdro.id/api/"

        fun create() : CoronaGlobalService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CoronaGlobalService::class.java)

        }
    }
}