package com.aras.movies.ui.detail.tvshow

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.databinding.ActivityDetailMovieBinding
import com.aras.movies.databinding.ContentDetailMovieBinding
import com.aras.movies.ui.detail.movie.DetailMovieActivity
import com.aras.movies.ui.detail.movie.DetailMovieViewModel
import com.aras.movies.viewmodel.ViewModelFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailTvshowActivity : AppCompatActivity() {
    private lateinit var detailContentBinding: ContentDetailMovieBinding

    companion object {
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
            val tvshowId = extras.getInt(DetailMovieActivity.EXTRA_TVSHOW)

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

    private fun populateTvshow(tvshowEntity: TvshowItems) {
        detailContentBinding.apply {
            textTitleMovie.text = tvshowEntity.name
            textReleaseMovie.text = tvshowEntity.firstAirDate
            textOverviewMovie.text = tvshowEntity.overview

            Glide.with(this@DetailTvshowActivity)
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