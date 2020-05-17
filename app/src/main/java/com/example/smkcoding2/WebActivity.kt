package com.example.smkcoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.NewsApi.WebDeveloper.WebAdapter
import com.example.smkcoding2.NewsApi.WebDeveloper.WebApiItem
import kotlinx.android.synthetic.main.activity_web.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: WebAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = WebAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = HomeService.create().getWeb()

        apiInterface.enqueue( object : Callback<List<WebApiItem>> {
            override fun onResponse(call: Call<List<WebApiItem>>?, response: Response<List<WebApiItem>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<WebApiItem>>?, t: Throwable?) {

            }
        })
    }
}
