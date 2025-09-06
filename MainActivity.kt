// MainActivity.kt
package com.lovecompanion.app

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    
    private lateinit var viewPager: ViewPager2
    private lateinit var bottomNav: BottomNavigationView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        setupViewPager()
        setupBottomNavigation()
    }
    
    private fun setupViewPager() {
        viewPager = findViewById(R.id.viewPager)
        val adapter = LoveFragmentAdapter(this)
        viewPager.adapter = adapter
    }
    
    private fun setupBottomNavigation() {
        bottomNav = findViewById(R.id.bottomNavigation)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_quotes -> {
                    viewPager.currentItem = 0
                    true
                }
                R.id.nav_milestones -> {
                    viewPager.currentItem = 1
                    true
                }
                R.id.nav_memories -> {
                    viewPager.currentItem = 2
                    true
                }
                else -> false
            }
        }
        
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                bottomNav.menu.getItem(position).isChecked = true
            }
        })
    }
}
