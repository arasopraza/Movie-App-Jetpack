package com.aras.movies.ui.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aras.movies.R
import com.aras.movies.data.source.local.entity.TvshowEntity
import com.aras.movies.databinding.ItemsMovieBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvshowViewHolder>() {
    private var listTvshows = ArrayList<TvshowEntity>()

    fun setTvshows(tvshows: List<TvshowEntity>?) {
        if (tvshows == null) return
        this.listTvshows.clear()
        this.listTvshows.addAll(tvshows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowViewHolder {
        val itemsTvshowBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowViewHolder(itemsTvshowBinding)
    }

    override fun getItemCount(): Int {
        return listTvshows.size

    }

    override fun onBindViewHolder(holder: TvshowViewHolder, position: Int) {
        val tvshow = listTvshows[position]
        holder.bind(tvshow)
    }

    class TvshowViewHolder(private val binding: ItemsMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvshowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.name
                tvItemDate.text = tvshow.firstAirDate
                tvItemOverview.text = tvshow.overview

//                itemView.setOnClickListener{
//                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
//                    intent.putExtra(DetailMovieActivity.EXTRA_TVSHOW, tvshow.tvshowId)
//                    itemView.context.startActivity(intent)
//                }

                Glide.with(itemView.context)
                        .load(tvshow.posterPath)
                        .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                                .error(R.drawable.ic_error))
                        .into(imgPoster)
            }
        }
    }
}