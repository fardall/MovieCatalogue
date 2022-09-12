package com.example.moviecatalogue.ui.favorite

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.ItemsFilmBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class FavoriteAdapter(private val viewType: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var listMovies = ArrayList<Film>()
    private var listShows = ArrayList<Film>()

    companion object {
        const val LAYOUT_ONE = 0
        const val LAYOUT_TWO = 1
    }

    fun setFavMovie(movies: List<Film>) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    fun setFavShows(shows: List<Film>) {
        if (shows == null) return
        this.listMovies.clear()
        this.listMovies.addAll(shows)
    }

    override fun getItemViewType(position: Int): Int {
        return when (viewType) {
            0 -> LAYOUT_ONE
         else -> LAYOUT_TWO
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context))
        return when (this.viewType) {
            LAYOUT_ONE -> MovieViewHolder(binding)
            else -> ShowViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            LAYOUT_ONE -> {
                val movieHolder = holder as MovieViewHolder
                val movie = listMovies[position]
                movieHolder.bind(movie) }
            else -> {
                val showHolder = holder as ShowViewHolder
                val show = listShows[position]
                showHolder.bind(show)
            }
        }
    }

    override fun getItemCount(): Int {
        return when (viewType) {
            LAYOUT_ONE -> listMovies.size
            else -> listShows.size
        }
    }

    class MovieViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Film) {
            with(binding) {
                tvTitle.text = movie.title
                tvDescription.text = movie.description
                itemView.setOnClickListener {
                    val toDetailFilm = Intent(itemView.context, DetailFilmActivity::class.java)
                    toDetailFilm.putExtra(DetailFilmActivity.EXTRA_NAME, movie.title)
                    itemView.context.startActivity(toDetailFilm)
                }
                Glide .with(itemView.context)
                    .load(movie.poster)
                    .into(ivPoster)
            }
        }
    }

    class ShowViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Film) {
            with(binding) {
                tvTitle.text = show.title
                tvDescription.text = show.description
                itemView.setOnClickListener {
                    val toDetailFilm = Intent(itemView.context, DetailFilmActivity::class.java)
                    toDetailFilm.putExtra(DetailFilmActivity.EXTRA_NAME, show.title)
                    itemView.context.startActivity(toDetailFilm)
                }
                Glide .with(itemView.context)
                    .load(show.poster)
                    .into(ivPoster)
            }
        }
    }
}