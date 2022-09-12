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
import com.example.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {
    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var movieAdapter: FavoritePagedListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

        val filmObserver = Observer<PagedList<Film>> { movies ->
            if (movies != null) {
                binding.progressBar.visibility = View.GONE
                movieAdapter.submitList(movies)
            }
        }

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getMovies().observe(viewLifecycleOwner, filmObserver)

        movieAdapter = FavoritePagedListAdapter(requireActivity())

        with(binding.rvFavMovie) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = movieAdapter
        }

    }

}