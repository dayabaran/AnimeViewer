package com.example.animeviewer

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.animeviewer.databinding.AnimeListItemBinding
import com.example.animeviewer.model.AnimeItem

class AnimeAdapter : RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder>() {

    private var animeList: ArrayList<AnimeItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val animeListItemBinding = DataBindingUtil.inflate<AnimeListItemBinding>(
            LayoutInflater.from(parent.context),
            R.layout.anime_list_item, parent, false
        )
        return  AnimeViewHolder(animeListItemBinding)

    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val currentItem = animeList!![position]
        holder.binding.animeItemModel = currentItem
    }

    fun setAnimeList(animeList :ArrayList<AnimeItem>) {
        this.animeList = animeList;
        notifyDataSetChanged()
    }

    override fun getItemCount() : Int {
         return if (animeList != null) {
            animeList!!.size
        } else {
            0
        }
    }


    inner class AnimeViewHolder(var binding: AnimeListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    }
