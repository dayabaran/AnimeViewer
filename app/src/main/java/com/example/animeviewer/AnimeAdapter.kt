package com.example.animeviewer

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.animeviewer.databinding.AnimeListItemBinding
import com.example.animeviewer.databinding.AnimeRowItemBinding
import com.example.animeviewer.model.NewsArticle

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var items: List<NewsArticle> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_list_item,parent,false)
        return  AnimeViewHolder(view)

    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun swapItems(items : List<NewsArticle>) {
        this.items = items
        notifyDataSetChanged()
    }
    override fun getItemCount() = items.size

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = AnimeListItemBinding.bind(itemView)
        fun bind(animeItem: NewsArticle) = with(itemView) {
            Log.d("MYTAG",animeItem.title.toString())
           binding.animeTitle.text = animeItem.title
        }
    }
    }
