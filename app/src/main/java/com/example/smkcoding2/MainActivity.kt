package com.example.smkcoding2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val tabTeks = arrayOf("Home", "News", "User")
    val tabIcon = arrayOf(R.drawable.home, R.drawable.news, R.drawable.user)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(this)
        viewPager.setAdapter(adapter);
        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.text = tabTeks[position]
            tab.icon = ResourcesCompat.getDrawable(resources,tabIcon[position],null)

            }).attach()
        }
    }
