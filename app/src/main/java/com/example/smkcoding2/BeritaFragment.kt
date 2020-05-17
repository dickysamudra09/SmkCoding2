package com.example.smkcoding2

import android.content.Intent
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
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaAdapter
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_berita_fragment.*
import kotlinx.android.synthetic.main.activity_berita_fragment_item_head.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BeritaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_berita_fragment, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnDetail.setOnClickListener {
            val move = Intent(context, CoronaGlobalActivity::class.java)
            startActivity(move)
        }

        callApiGetNews()
    }

    private fun callApiGetNews(){
        showLoading(context!!, headNews)

        val httpClient = httpClient()
        val apiRequest = apiRequestNews<CoronaService>(httpClient)

        val call = apiRequest.getCorona()
        call.enqueue(object: Callback<List<CoronaApiItem>> {

            override fun onFailure(call: Call<List<CoronaApiItem>>, t:Throwable){
                dismissLoading(headNews)
            }

            override fun onResponse(call: Call<List<CoronaApiItem>>, response: Response<List<CoronaApiItem>>){
                dismissLoading(headNews)

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
        listNewsHead.layoutManager = LinearLayoutManager(context)
        listNewsHead.adapter = CoronaAdapter(context!!, newsBody){
            showToast(context!!, "Update")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
