package com.example.moviecatalogue.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.moviecatalogue.ui.movies.MoviesFragment
import com.example.moviecatalogue.ui.shows.ShowsFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MoviesFragment()
            1 -> fragment = ShowsFragment()
        }
        return fragment as Fragment
    }

}