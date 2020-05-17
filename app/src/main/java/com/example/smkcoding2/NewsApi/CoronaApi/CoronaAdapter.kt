package com.example.smkcoding2.NewsApi.CoronaApi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_berita_fragment_item_head.*
import kotlinx.android.synthetic.main.activity_corona_global_item.*


class CoronaAdapter(private val context: Context, private val items: List<CoronaApiItem>, private val listener: (CoronaApiItem)->
Unit): RecyclerView.Adapter<CoronaAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.activity_berita_fragment_item_head, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun binditem(item: CoronaApiItem, listener: (CoronaApiItem) -> Unit){
            totalInfeksi.text = item.confirmed.toString()

            containerView.setOnClickListener{listener(item)}
        }
    }
}