package com.example.smkcoding2.NewsApi.DataScience

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_home_item.*


class DataScienceAdapter(val context: Context) : RecyclerView.Adapter<DataScienceAdapter.MyViewHolder>() {

    var dataList: List<DataScienceApiItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_datascience_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txPosition.text = dataList.get(position).title
        holder.txCompany.text = dataList.get(position).company
        Glide.with(context).load(dataList.get(position).companyLogo)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<DataScienceApiItem>) {
        this.dataList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val txPosition: TextView = itemView!!.findViewById(R.id.txPosition)
        val txCompany: TextView = itemView!!.findViewById(R.id.txCompany)
        val image: ImageView = itemView!!.findViewById(R.id.imgJob)

    }
}