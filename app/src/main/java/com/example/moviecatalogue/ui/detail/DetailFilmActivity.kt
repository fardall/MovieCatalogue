package com.example.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = intent.getStringExtra(EXTRA_FILM)!!

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        binding.progressBar.visibility = View.VISIBLE
        viewModel.getFilm(title).observe(this, {
            binding.progressBar.visibility = View.GONE
            if (it != null) {
                film = it
            }

            val adapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.casts, R.id.tv_castName, film.casts
            )

            with(binding) {
                listCasts.adapter = adapter
                tvTitle.text = film.title
                tvStatus.text = film.status
                tvLanguage.text = film.originalLanguage
                tvDescription.text = film.description

                Glide .with(this@DetailFilmActivity)
                    .load(film.poster)
                    .centerCrop()
                    .into(ivPoster)
            }
        })



    }

    companion object {
        const val EXTRA_FILM = "extra_film"
    }
}