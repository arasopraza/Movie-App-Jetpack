package com.aras.movies.ui.detail.tvshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.local.entity.TvshowEntity
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
            viewModel.getTvshow().observe(this, {
                activityDetailMovieBinding.progressBar.visibility = View.GONE
                activityDetailMovieBinding.content.visibility = View.VISIBLE
                populateTvshow(it)
            })
        }
    }

    private fun populateTvshow(tvshowEntity: TvshowEntity) {
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