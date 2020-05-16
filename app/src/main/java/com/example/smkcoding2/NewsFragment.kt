package com.example.smkcoding2

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.FunctionData.Data.apiRequestNews
import com.example.smkcoding2.FunctionData.Data.httpClient
import com.example.smkcoding2.FunctionData.Utils.dismissLoading
import com.example.smkcoding2.FunctionData.Utils.showLoading
import com.example.smkcoding2.FunctionData.Utils.showToast
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaAdapter
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card1.setOnClickListener{goToActivity()}

        callApiGetNews()
    }

    private fun goToActivity() {
        val i = Intent(this.activity, WebActivity::class.java)
        (i)
    }

    private fun callApiGetNews(){
        showLoading(context!!, newsLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequestNews<HomeService>(httpClient)

        val call = apiRequest.getCorona()
        call.enqueue(object: Callback<List<CoronaApiItem>> {

            override fun onFailure(call: Call<List<CoronaApiItem>>, t:Throwable){
                dismissLoading(newsLayout)
            }

            override fun onResponse(call: Call<List<CoronaApiItem>>, response: Response<List<CoronaApiItem>>){
                dismissLoading(newsLayout)

                when {
                    response.isSuccessful->
                        when {
                            response.body()?.size !=0->
                                showNews(response.body()!!)
                            else->{
                                showToast(context!!, "Berhasil")
                            }
                        }
                    else->{
                        showToast(context!!, "Gagal")
                    }
                }
            }
        })
    }

    private fun showNews(newsBody: List<CoronaApiItem>) {
        listNewsFragment.layoutManager = LinearLayoutManager(context)
        listNewsFragment.adapter = CoronaAdapter(context!!, newsBody){
            showToast(context!!, "Update")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}