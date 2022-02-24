package com.example.moviecatalogue.ui.shows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.ItemsFilmBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class ShowsAdapter : RecyclerView.Adapter<ShowsAdapter.ViewHolder>() {
    private var listShows = ArrayList<Film>()

    fun setShows(Shows: List<Film>?) {
        if (Shows == null) return
        this.listShows.clear()
        this.listShows.addAll(Shows)
    }

    class ViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Film) {
            with(binding) {
                tvTitle.text = show.title
                tvDescription.text = show.description
                itemView.setOnClickListener{
                    val toDetailFilm = Intent(itemView.context, DetailFilmActivity::class.java)
                    toDetailFilm.putExtra(DetailFilmActivity.EXTRA_FILM, show.title)
                    itemView.context.startActivity(toDetailFilm)
                }
                Glide .with(itemView.context)
                    .load(show.poster)
                    .into(ivPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show = listShows[position]
        holder.bind(show)
    }

    override fun getItemCount(): Int {
        return listShows.size
    }
}