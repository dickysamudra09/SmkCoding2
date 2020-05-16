package com.example.smkcoding2.NewsApi.WebDeveloper


import com.google.gson.annotations.SerializedName

data class WebApiItem(
    @SerializedName("company")
    val company: String,
    @SerializedName("company_logo")
    val companyLogo: String,
    @SerializedName("company_url")
    val companyUrl: String,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("how_to_apply")
    val howToApply: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)