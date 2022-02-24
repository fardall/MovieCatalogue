package com.example.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.ui.detail.DetailFilmActivity
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.ItemsFilmBinding

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {
    private var listMovies = ArrayList<Film>()

    fun setMovies(movies: List<Film>) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    class ViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Film) {
            with(binding) {
                tvTitle.text = movie.title
                tvDescription.text = movie.description
                itemView.setOnClickListener{
                    val toDetailFilm = Intent(itemView.context, DetailFilmActivity::class.java)
                    toDetailFilm.putExtra(DetailFilmActivity.EXTRA_FILM, movie.title)
                    itemView.context.startActivity(toDetailFilm)
                }
                Glide .with(itemView.context)
                    .load(movie.poster)
                    .into(ivPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
}