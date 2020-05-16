package com.example.smkcoding2.NewsApi.AndroidDeveloper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaAdapter
import com.example.smkcoding2.NewsApi.CoronaApi.CoronaApiItem
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_news_item.*

class AndroidAdapter (private val context: Context, private val items: List<AndroidApi>, private val listener: (AndroidApi)->
Unit): RecyclerView.Adapter<AndroidAdapter.ViewHolder>(){

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
        fun binditem(item: AndroidApi, listener: (AndroidApi) -> Unit){


            containerView.setOnClickListener{listener(item)}
        }
    }
}