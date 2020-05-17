package com.example.smkcoding2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(){

    companion object{
        val REQUEST_CODE = 10000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAndroid.setOnClickListener {
            val move = Intent(context, AndroidActivity::class.java)
            startActivity(move)
        }
        btnWeb.setOnClickListener {
            val move = Intent(context, WebActivity::class.java)
            startActivity(move)
        }
        btnDataScience.setOnClickListener {
            val move = Intent(context, DataScienceActivity::class.java)
            startActivity(move)
        }
    }
}