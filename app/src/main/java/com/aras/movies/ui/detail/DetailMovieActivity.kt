package com.aras.movies.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.remote.response.MovieItems
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.databinding.ActivityDetailMovieBinding
import com.aras.movies.databinding.ContentDetailMovieBinding
import com.aras.movies.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MOVIE = "extra_movie"
        const val EXTRA_TVSHOW = "extra_tvshow"
    }

    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var detailContentBinding: ContentDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.title = resources.getString(R.string.detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            if (intent.hasExtra(EXTRA_MOVIE)) {
                val movieId = extras.getInt(EXTRA_MOVIE)
                viewModel.selectedMovie(movieId)

                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.content.visibility = View.INVISIBLE
                viewModel.getMovie().observe(this, { movies ->
                    activityDetailMovieBinding.progressBar.visibility = View.GONE
                    activityDetailMovieBinding.content.visibility = View.VISIBLE
                    populateMovie(movies)
                })
            } else if (intent.hasExtra(EXTRA_TVSHOW)) {
                val tvshowId = extras.getInt(EXTRA_TVSHOW)
                viewModel.selectedTvshow(tvshowId)

                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.content.visibility = View.INVISIBLE
                viewModel.getTvshow().observe(this, { tvshow ->
                    activityDetailMovieBinding.progressBar.visibility = View.GONE
                    activityDetailMovieBinding.content.visibility = View.VISIBLE
                    populateTvshow(tvshow)
                })
            }
        }
    }

    private fun populateMovie(movie: MovieItems) {
        detailContentBinding.apply {
            textTitleMovie.text = movie.title
            textReleaseMovie.text = movie.releaseDate
            textOverviewMovie.text = movie.overview

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500/" + movie.posterPath)
                .transform(RoundedCorners(16))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }
    }

    private fun populateTvshow(tvshowEntity: TvshowItems) {
        detailContentBinding.apply {
            textTitleMovie.text = tvshowEntity.name
            textReleaseMovie.text = tvshowEntity.firstAirDate
            textOverviewMovie.text = tvshowEntity.overview

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500/" + tvshowEntity.posterPath)
                .transform(RoundedCorners(16))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }
    }
}