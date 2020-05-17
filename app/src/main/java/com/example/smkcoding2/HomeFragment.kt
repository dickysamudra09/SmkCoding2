package com.example.smkcoding2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smkcoding2.FunctionData.Data.HomeService
import com.example.smkcoding2.FunctionData.Data.apiRequest
import com.example.smkcoding2.FunctionData.Data.httpClient
import com.example.smkcoding2.FunctionData.Utils.dismissLoading
import com.example.smkcoding2.FunctionData.Utils.showLoading
import com.example.smkcoding2.FunctionData.Utils.showToast
import com.example.smkcoding2.HomeApi.HomeJobsAdapter
import com.example.smkcoding2.HomeApi.JobsHomeItem
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetJobsHome()
    }


    private fun callApiGetJobsHome(){
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<HomeService>(httpClient)

        val call = apiRequest.getJobs()
        call.enqueue(object: Callback<List<JobsHomeItem>> {

            override fun onFailure(call: Call<List<JobsHomeItem>>, t:Throwable){
                dismissLoading(swipeRefreshLayout)
            }

            override fun onResponse(call: Call<List<JobsHomeItem>>, response: Response<List<JobsHomeItem>>){
                dismissLoading(swipeRefreshLayout)

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
        listHomeFragment.layoutManager = LinearLayoutManager(context)
        listHomeFragment.adapter = HomeJobsAdapter(context!!, jobsHome){
            val home = it
            showToast(context!!, home.title)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}