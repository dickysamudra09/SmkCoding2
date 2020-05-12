package com.example.smkcoding2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val JUMLAH_TAB = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0 -> { return HomeFragment() }
            1 -> { return NewsFragment() }
            2 -> { return UserFragment() }
            else -> {
                return HomeFragment()
            }
        }
    }

    override fun getItemCount(): Int {
        return JUMLAH_TAB
    }
}