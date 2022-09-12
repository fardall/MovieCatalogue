package com.example.moviecatalogue.ui.favorite

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.ItemsFilmBinding
import com.example.moviecatalogue.ui.detail.DetailFilmActivity

class FavoritePagedListAdapter(private val activity: Activity) : PagedListAdapter<Film, FavoritePagedListAdapter.FilmViewHolder>(DIFF_CALLBACK) {
    inner class FilmViewHolder(private val binding: ItemsFilmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvTitle.text = film.title
                tvDescription.text = film.description
                Glide .with(itemView.context)
                    .load(film.poster)
                    .into(ivPoster)
                itemView.setOnClickListener {
                    val toDetail = Intent(activity, DetailFilmActivity::class.java)
                    toDetail.putExtra(DetailFilmActivity.EXTRA_NAME, film.title)
                    activity.startActivity(toDetail)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<Film> = object : DiffUtil.ItemCallback<Film>() {
            override fun areItemsTheSame(oldFilm: Film, newFilm: Film): Boolean {
                return oldFilm.title == newFilm.title && oldFilm.description == newFilm.description
            }
            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldFilm: Film, newFilm: Film): Boolean {
                return oldFilm == newFilm
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemsFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        holder.bind(getItem(position) as Film)
    }
}