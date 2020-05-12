package com.example.smkcoding2.FunctionData.Utils

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.smkcoding2.R

fun showLoading(context: Context, swipeRefreshLayout: SwipeRefreshLayout) {
    swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(context, R.color.colorPrimary))

    swipeRefreshLayout.isEnabled = true
    swipeRefreshLayout.isRefreasing = true
}

fun dismisLoading(swipeRefreashLayout:swipeRefreashLayout){
    swipeRefreashLayout.isRefresing = false
    swipeRefreashLayout.isEnabled = false
}