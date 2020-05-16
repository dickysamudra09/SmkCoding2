package com.example.smkcoding2.NewsApi.DataScience

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.NewsApi.AndroidDeveloper.AndroidAdapter
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_news_item.*


class DataScienceAdapter(private val context: Context, private val items: List<DataScienceApi>, private val listener: (DataScienceApi)->
Unit): RecyclerView.Adapter<DataScienceAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.activity_android, parent, false
    )
    )


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun binditem(item: DataScienceApi, listener: (DataScienceApi) -> Unit){


            containerView.setOnClickListener{listener(item)}
        }
    }
}