package com.example.smkcoding2.NewsApi.CoronaApi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.R

class CoronaGlobalAdapter (val context: Context) : RecyclerView.Adapter<CoronaGlobalAdapter.MyViewHolder>() {

    var globalList: List<CoronaGlobalApiItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_corona_global_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return globalList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txcountry.text = globalList.get(position).countryRegion
        holder.txInfeksi.text = globalList.get(position).confirmed.toString()
        holder.txrecover.text = globalList.get(position).recovered.toString()
        holder.txdeath.text = globalList.get(position).deaths.toString()
    }

    fun setMovieListItems(movieList: List<CoronaGlobalApiItem>) {
        this.globalList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val txcountry: TextView = itemView!!.findViewById(R.id.txCountry)
        val txInfeksi: TextView = itemView!!.findViewById(R.id.txInfeksi)
        val txrecover: TextView = itemView!!.findViewById(R.id.txRecovery)
        val txdeath: TextView = itemView!!.findViewById(R.id.txDeath)

    }
}