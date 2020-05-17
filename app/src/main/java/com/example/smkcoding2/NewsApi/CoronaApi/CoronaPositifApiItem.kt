package com.example.smkcoding2.NewsApi.CoronaApi


import com.google.gson.annotations.SerializedName

data class CoronaPositifApiItem(
    @SerializedName("latestWkidConfirmed")
    val latestWkidConfirmed: String,
    @SerializedName("nameConfirmed")
    val nameConfirmed: String,
    @SerializedName("TotalConfirmed")
    val totalConfirmed: String,
    @SerializedName("wkidConfirmed")
    val wkidConfirmed: String
)