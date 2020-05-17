package com.example.smkcoding2.NewsApi.WebDeveloper

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

class WebAdapter(val context: Context) : RecyclerView.Adapter<WebAdapter.MyViewHolder>() {

    var webList: List<WebApiItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_web_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return webList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.txPosition.text = webList.get(position).title
        holder.txCompany.text = webList.get(position).company
        Glide.with(context).load(webList.get(position).companyLogo)
            .apply(RequestOptions().centerCrop())
            .into(holder.image)
    }

    fun setMovieListItems(movieList: List<WebApiItem>) {
        this.webList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val txPosition: TextView = itemView!!.findViewById(R.id.txPosition)
        val txCompany: TextView = itemView!!.findViewById(R.id.txCompany)
        val image: ImageView = itemView!!.findViewById(R.id.imgJob)

    }
}