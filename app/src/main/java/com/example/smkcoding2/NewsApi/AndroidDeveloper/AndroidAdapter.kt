package com.example.smkcoding2.NewsApi.AndroidDeveloper

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

class AndroidAdapter(val context: Context) : RecyclerView.Adapter<AndroidAdapter.MyViewHolder>() {

    var androidList : List<AndroidApiItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_android_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return androidList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txPosition.text = androidList.get(position).title
        holder.txCompany.text = androidList.get(position).company
        Glide.with(context).load(androidList.get(position).companyLogo)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<AndroidApiItem>){
        this.androidList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val txPosition: TextView = itemView!!.findViewById(R.id.txPosition)
        val txCompany: TextView = itemView!!.findViewById(R.id.txCompany)
        val image: ImageView = itemView!!.findViewById(R.id.imgJob)

    }
}