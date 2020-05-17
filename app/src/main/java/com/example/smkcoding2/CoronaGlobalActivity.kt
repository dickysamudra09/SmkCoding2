package com.example.smkcoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.FunctionData.Data.CoronaGlobalService
import com.example.smkcoding2.FunctionData.Data.CoronaStatus
import com.example.smkcoding2.FunctionData.Data.CoronaStatusRecovered
import com.example.smkcoding2.NewsApi.CoronaApi.*
import kotlinx.android.synthetic.main.activity_corona_global.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CoronaGlobalActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerView1: RecyclerView
    lateinit var recyclerView2: RecyclerView
    lateinit var recyclerAdapter: CoronaGlobalAdapter
    lateinit var recyclerAdapter1: CoronaPositifAdapter
    lateinit var recyclerAdapter2: CoronaRecoveredAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_corona_global)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = CoronaGlobalAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        recyclerView1 = findViewById(R.id.recyclerview1)
        recyclerAdapter1 = CoronaPositifAdapter(this)
        recyclerview1.layoutManager = LinearLayoutManager(this)
        recyclerView1.adapter = recyclerAdapter1

        val apiInterface = CoronaGlobalService.create().getCoronaGlobal()
        val apiInterface2 = CoronaStatus.create().getCoronaStatusPo()
        val apiInterface3 = CoronaStatusRecovered.create().getCoronaStatusRe()

        apiInterface.enqueue( object : Callback<List<CoronaGlobalApiItem>> {
            override fun onResponse(call: Call<List<CoronaGlobalApiItem>>?, response: Response<List<CoronaGlobalApiItem>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<CoronaGlobalApiItem>>?, t: Throwable?) {

            }
        })

        apiInterface2.enqueue( object : Callback<List<CoronaPositifApiItem>> {
            override fun onResponse(call: Call<List<CoronaPositifApiItem>>?, response: Response<List<CoronaPositifApiItem>>?) {

                if(response?.body() != null)
                    recyclerAdapter1.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<CoronaPositifApiItem>>?, t: Throwable?) {

            }
        })
    }
}
