package com.example.smkcoding2.NewsApi.CoronaApi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.R

class CoronaPositifAdapter (val context: Context) : RecyclerView.Adapter<CoronaPositifAdapter.MyViewHolder>() {

    var globalList: List<CoronaPositifApiItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_corona_global_status, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return globalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.txInfeksi.text = globalList.get(position).totalConfirmed
    }

    fun setMovieListItems(movieList: List<CoronaPositifApiItem>) {
        this.globalList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val txInfeksi: TextView = itemView!!.findViewById(R.id.txInfeksiGlobal)
    }
}