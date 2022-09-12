package com.example.moviecatalogue.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.moviecatalogue.databinding.ActivityFavoriteBinding
import com.google.android.material.tabs.TabLayoutMediator

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val favPagerAdapter = FavoritePagerAdapter(this)
        with(binding) {
            viewPager.adapter = favPagerAdapter
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = TAB_TITLES[position]
            }.attach()
        }

        supportActionBar?.title = "Favorite"
    }

    companion object {
        private val TAB_TITLES = arrayOf(
            "MOVIES",
            "TV SHOWS"
        )
    }
}