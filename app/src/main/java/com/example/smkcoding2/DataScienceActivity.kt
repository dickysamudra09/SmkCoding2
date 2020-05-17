package com.example.smkcoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.NewsApi.DataScience.DataScienceAdapter
import com.example.smkcoding2.NewsApi.DataScience.DataScienceApiItem
import kotlinx.android.synthetic.main.activity_data_science.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataScienceActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: DataScienceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_science)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = DataScienceAdapter(this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = HomeService.create().getDataScience()

        apiInterface.enqueue( object : Callback<List<DataScienceApiItem>> {
            override fun onResponse(call: Call<List<DataScienceApiItem>>?, response: Response<List<DataScienceApiItem>>?) {

                if(response?.body() != null)
                    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<DataScienceApiItem>>?, t: Throwable?) {

            }
        })
    }
}
