package com.aras.movies.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aras.movies.R
import com.aras.movies.data.source.remote.response.TvshowItems
import com.aras.movies.databinding.ItemsMovieBinding
import com.aras.movies.ui.detail.DetailMovieActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvshowViewHolder>() {
    private var listTvshows = ArrayList<TvshowItems>()

    fun setTvshows(tvshows: List<TvshowItems>?) {
        if (tvshows == null) return
        this.listTvshows.clear()
        this.listTvshows.addAll(tvshows)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val itemsTvshowBinding =
            ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(itemsTvshowBinding)
    }

    override fun getItemCount(): Int {
        return listTvshows.size
    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = listTvshows[position]
        holder.bind(tvshow)
    }

    class TvshowViewHolder(private val binding: ItemsMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvshowItems) {
            with(binding) {
                tvItemTitle.text = tvshow.name
                tvItemDate.text = tvshow.firstAirDate
                tvItemOverview.text = tvshow.overview

                itemView.setOnClickListener{
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_TVSHOW, tvshow.tvshowId)
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/w500/" + tvshow.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgPoster)
            }
        }
    }
}