package com.aras.movies.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aras.movies.R
import com.aras.movies.data.source.local.entity.MovieEntity
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.databinding.ActivityDetailMovieBinding
import com.aras.movies.databinding.ContentDetailMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailMovieActivity : AppCompatActivity() {
//    private lateinit var detailContentBinding: ContentDetailMovieBinding
//
//    companion object {
//        const val EXTRA_MOVIE = "extra_movie"
//        const val EXTRA_TVSHOW = "extra_tvshow"
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
//        detailContentBinding = activityDetailMovieBinding.detailContent
//
//        setContentView(activityDetailMovieBinding.root)
//
//        setSupportActionBar(activityDetailMovieBinding.toolbar)
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]
//
////        intent.extras?.let {
////            it.getString(EXTRA_MOVIE)?.apply {
////                viewModel.selectedMovie(this)
////                showDetail(viewModel.getMovies())
////            }
////        }
//
//        val extras = intent.extras
//        if (extras != null) {
//            val movieId = extras.getString(EXTRA_MOVIE)
//            val tvshowId = extras.getString(EXTRA_TVSHOW)
//
//            if (movieId != null) {
//                viewModel.selectedMovie(movieId)
//                populateMovie(viewModel.getMovies())
//            }
//
//            if (tvshowId != null) {
//                viewModel.selectedTvshow(tvshowId)
//                populateTvshow(viewModel.getTvshows())
//            }
//        }
//    }
//
//    private fun populateMovie(movieEntity: MovieEntity) {
//        detailContentBinding.apply {
//            textTitleMovie.text = movieEntity.title
//            textReleaseMovie.text = movieEntity.release
//            textOverviewMovie.text = movieEntity.description
//
//            Glide.with(this@DetailMovieActivity)
//                    .load(movieEntity.imagePath)
//                    .transform(RoundedCorners(16))
//                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
//                            .error(R.drawable.ic_error))
//                    .into(imagePoster)
//        }
//    }
//
//    private fun populateTvshow(tvshowEntity: TvshowEntity) {
//        detailContentBinding.apply {
//            textTitleMovie.text = tvshowEntity.title
//            textReleaseMovie.text = tvshowEntity.release
//            textOverviewMovie.text = tvshowEntity.description
//
//            Glide.with(this@DetailMovieActivity)
//                    .load(tvshowEntity.imagePath)
//                    .transform(RoundedCorners(16))
//                    .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
//                            .error(R.drawable.ic_error))
//                    .into(imagePoster)
//        }
//    }
}