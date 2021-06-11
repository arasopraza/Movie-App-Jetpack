package com.aras.movies.ui.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aras.movies.databinding.FragmentTvshowBinding
import com.aras.movies.viewmodel.ViewModelFactory
import com.aras.movies.vo.Status

class TvShowFragment : Fragment() {
    private var fragmentTvshowBinding: FragmentTvshowBinding? = null
    private val binding get() = fragmentTvshowBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentTvshowBinding = FragmentTvshowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]


            val tvshowAdapter = TvShowAdapter()

            viewModel.getTvShow().observe(viewLifecycleOwner, { tvshow ->
                if (tvshow != null) {
                    when (tvshow.status) {
                        Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            binding?.progressBar?.visibility = View.GONE
                            tvshowAdapter.submitList(tvshow.data)
                            tvshowAdapter.notifyDataSetChanged()
                        }
                        Status.ERROR -> {
                            binding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })

            with(fragmentTvshowBinding?.rvTvshow) {
                this?.layoutManager = LinearLayoutManager(context)
                this?.setHasFixedSize(true)
                this?.adapter = tvshowAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentTvshowBinding = null
    }
}