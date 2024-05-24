package com.busanit.test2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit.test2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

// TabLayout과 ViewPager2를 설정하고 FragmentStateAdapter를 사용하여 Fragment를 연동.
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: MyFragmentStateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MyFragmentStateAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "First"
                1 -> "Second"
                2 -> "Third"
                else -> null
            }
        }.attach()

    }
}