package com.aras.movies.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aras.movies.databinding.FragmentMovieBinding
import com.aras.movies.ui.favorite.FavoriteViewModel
import com.aras.movies.ui.tvshow.TvShowAdapter
import com.aras.movies.viewmodel.ViewModelFactory

class FavoriteTvshowFragment : Fragment() {
    private var fragmentBinding: FragmentMovieBinding? = null
    private val binding get() = fragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[FavoriteViewModel::class.java]

            val movieAdapter = TvShowAdapter()
            fragmentBinding?.progressBar?.visibility = View.VISIBLE
            viewModel.getTvshow().observe(viewLifecycleOwner, { tvshow ->
                fragmentBinding?.progressBar?.visibility = View.GONE
                movieAdapter.submitList(tvshow)
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
        fragmentBinding = null
    }
}