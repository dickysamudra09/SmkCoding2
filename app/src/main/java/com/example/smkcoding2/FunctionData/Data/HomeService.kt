package com.example.smkcoding2.FunctionData.Data

import com.example.smkcoding2.JobsHomeItem
import retrofit2.Call
import retrofit2.http.GET

interface HomeService{
    @GET("positions.json")
    fun getJobs():Call<List<JobsHomeItem>>
}