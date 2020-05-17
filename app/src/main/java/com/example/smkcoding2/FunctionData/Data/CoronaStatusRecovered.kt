package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.NewsApi.CoronaApi.CoronaRecoveredApiItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoronaStatusRecovered {

    @GET("recovered")
    fun getCoronaStatusRe(): Call<List<CoronaRecoveredApiItem>>

    companion object {

        var BASE_URL = "https://api.kawalcorona.com/"

        fun create() : CoronaStatusRecovered {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(CoronaStatusRecovered::class.java)

        }
    }
}