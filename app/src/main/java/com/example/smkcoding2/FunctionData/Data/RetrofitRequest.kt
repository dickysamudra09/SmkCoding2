package com.example.smkcoding2.FunctionData.Data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun httpClient(): OkHttpClient{
    val logInterceptor = HttpLoggingInterceptor()
    logInterceptor.level = HttpLoggingInterceptor.Level.BODY

    val builder = OkHttpClient.Builder()

    builder.readTimeout(15, TimeUnit.SECONDS)
    builder.connectTimeout(15, TimeUnit.SECONDS)
    builder.addInterceptor(logInterceptor)

    return builder.build()
}

inline fun<reified T>apiRequest(okHttpClient: OkHttpClient): T{
    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jobs.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    return retrofit.create(T::class.java)
}

inline fun<reified T>apiRequestNews(okHttpClient: OkHttpClient): T{
    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://covid19.mathdro.id/api/countries/indonesia/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    return retrofit.create(T::class.java)
}

inline fun<reified T>apiRequestWeb(okHttpClient: OkHttpClient): T{
    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jobs.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    return retrofit.create(T::class.java)
}

inline fun<reified T>apiRequestAndroid(okHttpClient: OkHttpClient): T{
    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jobs.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    return retrofit.create(T::class.java)
}

inline fun<reified T>apiRequestDataScience(okHttpClient: OkHttpClient): T{
    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://jobs.github.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    return retrofit.create(T::class.java)
}

object DataRepository {

    fun create(): HomeService {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jobs.github.com/")
            .build()
        return retrofit.create(HomeService::class.java)
    }
}
