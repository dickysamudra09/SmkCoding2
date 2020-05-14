package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.HomeApi.JobsHomeItem
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import retrofit2.Call
import retrofit2.http.GET

interface HomeService{
    @GET("positions.json")
    fun getJobs():Call<List<JobsHomeItem>>

    @GET("confirmed")
    fun getCorona():Call<List<CoronaApiItem>>
}