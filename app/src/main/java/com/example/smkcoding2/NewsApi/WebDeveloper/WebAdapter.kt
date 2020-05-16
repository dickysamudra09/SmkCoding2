package com.example.smkcoding2.NewsApi.WebDeveloper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.smkcoding2.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_android_item.*

class WebAdapter(private val context: Context, private val items: List<WebApiItem>, private val listener: (WebApiItem)->
Unit): RecyclerView.Adapter<WebAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.activity_web_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items.get(position), listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(val context: Context, override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun binditem(item: WebApiItem, listener: (WebApiItem) -> Unit){
            txCompany.text = item.company
            txPosition.text = item.title

            containerView.setOnClickListener{listener(item)}
        }
    }
}