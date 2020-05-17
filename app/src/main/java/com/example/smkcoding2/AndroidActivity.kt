package com.example.smkcoding2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.FunctionData.Data.DataRepository
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidAdapter
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidApiItem
import kotlinx.android.synthetic.main.activity_android.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AndroidActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: AndroidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = AndroidAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = HomeService.create().getAndroid()

        apiInterface.enqueue( object : Callback<List<AndroidApiItem>> {
            override fun onResponse(call: Call<List<AndroidApiItem>>?, response: Response<List<AndroidApiItem>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<AndroidApiItem>>?, t: Throwable?) {

            }
        })
    }
}
