package com.example.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.source.local.Film
import com.example.moviecatalogue.databinding.ActivityDetailFilmBinding
import com.example.moviecatalogue.viewmodel.ViewModelFactory

class DetailFilmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailFilmBinding
    private lateinit var title: String
    private lateinit var film: Film
    private lateinit var adapter: ArrayAdapter<String>
    private var isFavorite: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_NAME)!!

        val factory = ViewModelFactory.getInstance(this)
        factory.application = this.application
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        viewModel.getFilm(title)?.observe(this, { rFilm ->
            if (rFilm != null) {
                isFavorite = rFilm.isFavorite
            }
        })

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getFilm(title)?.observe(this, {
            binding.progressBar.visibility = View.GONE
            if (it != null) {
                film = it
                adapter = ArrayAdapter(
                    this, R.layout.casts, R.id.tv_castName, film.casts
                )
            }
            if (isFavorite == 1) {
                film.isFavorite = isFavorite
            }

            with(binding) {
                listCasts.adapter = adapter
                tvTitle.text = film.title
                tvStatus.text = film.status
                tvLanguage.text = film.originalLanguage
                tvDescription.text = film.description

                Glide.with(this@DetailFilmActivity)
                    .load(film.poster)
                    .centerCrop()
                    .into(ivPoster)
            }

            if (film.isFavorite == 0) {
                binding.fabFavorite.setOnClickListener {
                    binding.fabFavorite.isEnabled = false
                    binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this@DetailFilmActivity, R.drawable.ic_baseline_favorite_24_red))
                    viewModel.updateFavorite(title, 1)
                    Toast.makeText(
                        this@DetailFilmActivity,
                        "Berhasil Menambah Data",
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.fabFavorite.isEnabled = true
                    refresh()
                }
            } else {
                binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this@DetailFilmActivity, R.drawable.ic_baseline_favorite_24_red))
                binding.fabFavorite.setOnClickListener {
                    binding.fabFavorite.isEnabled = false
                    binding.fabFavorite.setImageDrawable(ContextCompat.getDrawable(this@DetailFilmActivity, R.drawable.ic_baseline_favorite_24))
                    viewModel.updateFavorite(title, 0)
                    Toast.makeText(this@DetailFilmActivity, "Berhasil menghapus data", Toast.LENGTH_SHORT)
                        .show()
                    binding.fabFavorite.isEnabled = true
                    refresh()
                }
            }
        })
    }

    private fun refresh() {
        finish()
        overridePendingTransition(0,0)
        startActivity(intent)
        overridePendingTransition(0,0)
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}