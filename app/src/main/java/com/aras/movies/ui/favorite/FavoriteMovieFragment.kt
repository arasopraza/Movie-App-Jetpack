package com.aras.movies.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aras.movies.databinding.FragmentMovieBinding
import com.aras.movies.ui.movie.MovieAdapter
import com.aras.movies.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {
    private var fragmentFavoriteMovieBinding: FragmentMovieBinding? = null
    private val binding get() = fragmentFavoriteMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteMovieBinding =
            FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val movieAdapter = MovieAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                fragmentFavoriteMovieBinding?.progressBar?.visibility = View.VISIBLE
                fragmentFavoriteMovieBinding?.progressBar?.visibility = View.GONE
                movieAdapter.setMovies(movies)
                movieAdapter.notifyDataSetChanged()
        })

        with(binding?.rvMovie) {
            this?.layoutManager = LinearLayoutManager(context)
            this?.setHasFixedSize(true)
            this?.adapter = movieAdapter
        }
    }
}

override fun onDestroy() {
    super.onDestroy()
    fragmentFavoriteMovieBinding = null
}
}
