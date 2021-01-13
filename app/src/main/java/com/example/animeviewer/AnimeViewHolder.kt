package com.example.animeviewer

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class AnimeViewHolder(v:View) : RecyclerView.ViewHolder(v),View.OnClickListener {


    init {
        v.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        Log.d("RecyclerView", "CLICK!")

    }
}