package com.example.smkcoding2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smkcoding2.FunctionData.Data.*
import com.example.smkcoding2.FunctionData.Utils.dismissLoading
import com.example.smkcoding2.FunctionData.Utils.showLoading
import com.example.smkcoding2.FunctionData.Utils.showToast
import com.example.smkcoding2.HomeApi.HomeJobsAdapter
import com.example.smkcoding2.HomeApi.JobsHomeItem
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidAdapter
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidApiItem
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaAdapter
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import com.example.smkcoding2.NewsApi.DataScience.DataScienceAdapter
import com.example.smkcoding2.NewsApi.DataScience.DataScienceApiItem
import com.example.smkcoding2.NewsApi.WebDeveloper.WebAdapter
import com.example.smkcoding2.NewsApi.WebDeveloper.WebApiItem
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

        callApiGetNews()
        callApiGetJobsHome()

        btn1.setOnClickListener { getListBtn1() }
        btn2.setOnClickListener { getListBtn2() }
        btn3.setOnClickListener { getListBtn3() }
    }

    private fun getListBtn3() {
        showLoading(context!!, newsLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequestDataScience<HomeService>(httpClient)

        val call = apiRequest.getDataScience()
        call.enqueue(object: Callback<List<DataScienceApiItem>> {

            override fun onFailure(call: Call<List<DataScienceApiItem>>, t:Throwable){
                dismissLoading(newsLayout)
            }

            override fun onResponse(call: Call<List<DataScienceApiItem>>, response: Response<List<DataScienceApiItem>>){
                dismissLoading(newsLayout)

                when {
                    response.isSuccessful->
                        when {
                            response.body()?.size !=0->
                                showNews3(response.body()!!)
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

    private fun showNews3(newsBody: List<DataScienceApiItem>) {
        listnews2.layoutManager = LinearLayoutManager(context)
        listnews2.adapter = DataScienceAdapter(context!!, newsBody){
            val it = it
            showToast(context!!, it.title)
        }
    }

    private fun getListBtn2() {
        showLoading(context!!, newsLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequestWeb<HomeService>(httpClient)

        val call = apiRequest.getWeb()
        call.enqueue(object: Callback<List<WebApiItem>> {

            override fun onFailure(call: Call<List<WebApiItem>>, t:Throwable){
                dismissLoading(newsLayout)
            }

            override fun onResponse(call: Call<List<WebApiItem>>, response: Response<List<WebApiItem>>){
                dismissLoading(newsLayout)

                when {
                    response.isSuccessful->
                        when {
                            response.body()?.size !=0->
                                showNews2(response.body()!!)
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

    private fun showNews2(newsBody: List<WebApiItem>) {
        listnews2.layoutManager = LinearLayoutManager(context)
        listnews2.adapter = WebAdapter(context!!, newsBody){
            val it = it
            showToast(context!!, it.title)
        }
    }

    private fun getListBtn1() {
        showLoading(context!!, newsLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequestAndroid<HomeService>(httpClient)

        val call = apiRequest.getAndroid()
        call.enqueue(object: Callback<List<AndroidApiItem>> {

            override fun onFailure(call: Call<List<AndroidApiItem>>, t:Throwable){
                dismissLoading(newsLayout)
            }

            override fun onResponse(call: Call<List<AndroidApiItem>>, response: Response<List<AndroidApiItem>>){
                dismissLoading(newsLayout)

                when {
                    response.isSuccessful->
                        when {
                            response.body()?.size !=0->
                                showNews1(response.body()!!)
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

    private fun showNews1(newsBody: List<AndroidApiItem>) {
        listnews2.layoutManager = LinearLayoutManager(context)
        listnews2.adapter = AndroidAdapter(context!!, newsBody){
            val it = it
            showToast(context!!, it.title)
        }
    }

    private fun callApiGetJobsHome(){
        showLoading(context!!, newsLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<HomeService>(httpClient)

        val call = apiRequest.getJobs()
        call.enqueue(object: Callback<List<JobsHomeItem>> {

            override fun onFailure(call: Call<List<JobsHomeItem>>, t:Throwable){
                dismissLoading(newsLayout)
            }

            override fun onResponse(call: Call<List<JobsHomeItem>>, response: Response<List<JobsHomeItem>>){
                dismissLoading(newsLayout)

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

    private fun showJobsHome(jobsHome: List<JobsHomeItem>){
        listnews2.layoutManager = LinearLayoutManager(context)
        listnews2.adapter = HomeJobsAdapter(context!!, jobsHome){
            val home = it
            showToast(context!!, home.title)
        }
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