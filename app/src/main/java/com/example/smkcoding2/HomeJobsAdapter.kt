package com.example.smkcoding2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_home_item.*
import com.example.smkcoding2.JobsHomeItem
import com.example.smkcoding2.R

class HomeJobsAdapter(private val context: Context, private val items: List<JobsHomeItem>, private val listener: (JobsHomeItem)->
    Unit): RecyclerView.Adapter<HomeJobsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(context, LayoutInflater.from(context).inflate(
        R.layout.fragment_home_item, parent, false))

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items.get(position), listener)
    }

    class ViewHolder(val context: Context, override val containerView: View):
            RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun binditem(item:JobsHomeItem, listener: (JobsHomeItem) -> Unit){
            txPosition.text = item.title
            txCompany.text = item.company

            Glide.with(context).load(item.companyLogo).into(imgJob)
            containerView.setOnClickListener{listener(item)}
        }
    }
}