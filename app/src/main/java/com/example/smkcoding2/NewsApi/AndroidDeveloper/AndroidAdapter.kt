package com.example.smkcoding2.NewsApi.AndroidDeveloper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_home_item.*
import kotlinx.android.synthetic.main.fragment_news_item.*
import kotlinx.android.synthetic.main.fragment_news_item.imgJob
import kotlinx.android.synthetic.main.fragment_news_item.txCompany
import kotlinx.android.synthetic.main.fragment_news_item.txPosition

class AndroidAdapter(private val context: Context, private val items: List<AndroidApiItem>, private val listener: (AndroidApiItem)->
Unit): RecyclerView.Adapter<AndroidAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.fragment_news_item2, parent, false
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
        fun binditem(item: AndroidApiItem, listener: (AndroidApiItem) -> Unit){
            txCompany.text = item.company
            txPosition.text = item.title

            Glide.with(context).load(item.companyLogo).into(imgJob)
            containerView.setOnClickListener{listener(item)}
        }
    }
}