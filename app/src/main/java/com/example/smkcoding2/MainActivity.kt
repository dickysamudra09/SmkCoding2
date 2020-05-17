package com.example.smkcoding2

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_news.*


class MainActivity : AppCompatActivity() {

    val tabIcon = arrayOf(R.drawable.home, R.drawable.category, R.drawable.ic_eye)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main)

        val adapter = ViewPagerAdapter(this)
        viewPager.setAdapter(adapter);
        TabLayoutMediator(tabLayout, viewPager, TabLayoutMediator.TabConfigurationStrategy { tab, position ->
            tab.icon = ResourcesCompat.getDrawable(resources,tabIcon[position],null)

            }).attach()
        }
}
