package com.aras.movies.ui.detail

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
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
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        detailContentBinding = activityDetailMovieBinding.detailContent

        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.title = resources.getString(R.string.detail_movie)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
//            if (intent.hasExtra(EXTRA_MOVIE)) {
                val movieId = extras.getInt(EXTRA_MOVIE)
                viewModel.selectedMovie(movieId)

                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
                activityDetailMovieBinding.content.visibility = View.INVISIBLE

                viewModel.getMovie().observe(this, { movies ->
                    activityDetailMovieBinding.progressBar.visibility = View.GONE
                    activityDetailMovieBinding.content.visibility = View.VISIBLE
                    populateMovie(movies)
                })
//            } else if (intent.hasExtra(EXTRA_TVSHOW)) {
//                val tvshowId = extras.getInt(EXTRA_TVSHOW)
//                viewModel.selectedTvshow(tvshowId)
//
//                activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
//                activityDetailMovieBinding.content.visibility = View.INVISIBLE
//
//                viewModel.getTvshow().observe(this, { tvshow ->
//                    activityDetailMovieBinding.progressBar.visibility = View.GONE
//                    activityDetailMovieBinding.content.visibility = View.VISIBLE
//                    populateTvshow(tvshow)
//                })
//            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getMovie().observe(this, { movie ->
            val state = movie.favorited
            setFavoriteState(state)
            Log.d(TAG, "Add Favorite ${setFavoriteState(state)} Movie Success")
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setMovieFavorite()
            Log.d(this@DetailMovieActivity.toString(), "Add Favorite Movie Success")
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun populateMovie(data: MovieEntity) {
        detailContentBinding.apply {
            textTitleMovie.text = data.title
            textReleaseMovie.text = data.releaseDate
            textOverviewMovie.text = data.overview

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500/" + data.posterPath)
                .transform(RoundedCorners(16))
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error)
                )
                .into(imagePoster)
        }
    }

//    private fun populateTvshow(data: TvshowEntity) {
//        detailContentBinding.apply {
//            textTitleMovie.text = data.name
//            textReleaseMovie.text = data.firstAirDate
//            textOverviewMovie.text = data.overview
//
//            Glide.with(this@DetailMovieActivity)
//                .load("https://image.tmdb.org/t/p/w500/" + data.posterPath)
//                .transform(RoundedCorners(16))
//                .apply(
//                    RequestOptions.placeholderOf(R.drawable.ic_loading)
//                        .error(R.drawable.ic_error)
//                )
//                .into(imagePoster)
//        }
//    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        }
    }
}