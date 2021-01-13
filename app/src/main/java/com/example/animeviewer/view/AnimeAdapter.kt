package com.example.animeviewer.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animeviewer.R
import com.example.animeviewer.databinding.AnimeListItemBinding
import com.example.animeviewer.model.AnimeItem

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var animeList: ArrayList<AnimeItem>? = null

    /**
     * Inflate the view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val animeListItemBinding = DataBindingUtil.inflate<AnimeListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.anime_list_item, parent, false
        )
        return  AnimeViewHolder(animeListItemBinding)

    }

    /**
     * Bind the view with the data
     */
    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val currentItem = animeList!![position]
        holder.binding.animeItemModel = currentItem
    }

    fun setAnimeList(animeList :ArrayList<AnimeItem>) {
        this.animeList = animeList;
        notifyDataSetChanged()
    }

    override fun getItemCount() : Int {
         return animeList?.size ?: 0;
    }

    /**
     * ViewHolder Pattern
     */
    inner class AnimeViewHolder(var binding: AnimeListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    }
