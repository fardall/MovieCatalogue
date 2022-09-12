package com.example.moviecatalogue.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.FragmentFavoriteShowsBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteShowsFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteShowsBinding
    private lateinit var showAdapter: FavoritePagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteShowsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        val filmObserver = Observer<PagedList<Film>> { shows ->
            if (shows != null) {
                binding.progressBar.visibility = View.GONE
                showAdapter.submitList(shows)
            }
        }

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getTvShows().observe(viewLifecycleOwner, filmObserver)

        showAdapter = FavoritePagedListAdapter(requireActivity())

        with(binding.rvFavShow) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = showAdapter
        }
    }
}