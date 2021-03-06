package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.HomeApi.JobsHomeItem
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidApiItem
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import com.example.smkcoding2.NewsApi.DataScience.DataScienceApiItem
import com.example.smkcoding2.NewsApi.WebDeveloper.WebApiItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface HomeService{
    @GET("positions.json")
    fun getJobs():Call<List<JobsHomeItem>>

    @GET("positions.json?description=web")
    fun getWeb():Call<List<WebApiItem>>

    @GET("positions.json?search=android")
    fun getAndroid():Call<List<AndroidApiItem>>

    @GET("positions.json?search=data-science")
    fun getDataScience():Call<List<DataScienceApiItem>>


    companion object {

        var BASE_URL = "https://jobs.github.com/"

        fun create() : HomeService {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(HomeService::class.java)

        }
    }
}


