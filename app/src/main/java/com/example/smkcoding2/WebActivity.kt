package com.example.smkcoding2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.FunctionData.Data.apiRequestWeb
import com.example.smkcoding2.FunctionData.Data.httpClient
import com.example.smkcoding2.FunctionData.Utils.dismissLoading
import com.example.smkcoding2.FunctionData.Utils.showLoading
import com.example.smkcoding2.FunctionData.Utils.showToast
import com.example.smkcoding2.NewsApi.WebDeveloper.WebAdapter
import com.example.smkcoding2.NewsApi.WebDeveloper.WebApiItem
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_web.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WebActivity : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_web, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetJobsHome()
    }

    private fun callApiGetJobsHome(){
        showLoading(context!!, swipeRefreshLayoutWeb)

        val httpClient = httpClient()
        val apiRequest = apiRequestWeb<HomeService>(httpClient)

        val call = apiRequest.getWeb()
        call.enqueue(object: Callback<List<WebApiItem>> {

            override fun onFailure(call: Call<List<WebApiItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayoutWeb)
            }

            override fun onResponse(call: Call<List<WebApiItem>>, response: Response<List<WebApiItem>>){
                dismissLoading(swipeRefreshLayoutWeb)

                when {
                    response.isSuccessful->
                        when {
                            response.body()?.size !=0->
                                showJobsHome(response.body()!!)
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

    private fun showJobsHome(tes: List<WebApiItem>){
        listWeb.layoutManager = LinearLayoutManager(context)
        listWeb.adapter = WebAdapter(context!!, tes){
            val home = it
            showToast(context!!, home.title)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}