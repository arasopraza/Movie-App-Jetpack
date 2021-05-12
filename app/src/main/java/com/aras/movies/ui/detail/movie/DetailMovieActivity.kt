package com.aras.movies.ui.detail.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.databinding.ActivityDetailMovieBinding
import com.aras.movies.databinding.ContentDetailMovieBinding
import com.aras.movies.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)

            viewModel.selectedMovie(movieId)

            activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
            activityDetailMovieBinding.content.visibility = View.INVISIBLE
            viewModel.getMovie().observe(this, { movies ->
                activityDetailMovieBinding.progressBar.visibility = View.GONE
                activityDetailMovieBinding.content.visibility = View.VISIBLE
                populateMovie(movies)
            })
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        detailContentBinding.apply {
            textTitleMovie.text = movieEntity.title
            textReleaseMovie.text = movieEntity.releaseDate
            textOverviewMovie.text = movieEntity.overview

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500/" + movieEntity.posterPath)
                .transform(RoundedCorners(16))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }
    }
}