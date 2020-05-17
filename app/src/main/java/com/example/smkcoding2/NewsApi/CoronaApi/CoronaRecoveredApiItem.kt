package com.example.smkcoding2.NewsApi.CoronaApi


import com.google.gson.annotations.SerializedName

data class CoronaRecoveredApiItem(
    @SerializedName("latestWkidRecovered")
    val latestWkidRecovered: String,
    @SerializedName("nameRecovered")
    val nameRecovered: String,
    @SerializedName("TotalRecovered")
    val totalRecovered: String,
    @SerializedName("wkidRecovered")
    val wkidRecovered: String
)