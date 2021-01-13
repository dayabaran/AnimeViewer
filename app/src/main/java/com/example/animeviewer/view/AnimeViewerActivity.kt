package com.example.animeviewer.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeviewer.databinding.ActivityMainBinding
import com.example.animeviewer.model.AnimeItem
import com.example.animeviewer.viewmodel.AnimeViewModel
import java.util.*
import kotlin.collections.ArrayList

class AnimeViewerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: AnimeAdapter? = null

    private val animeViewModel by lazy { ViewModelProvider(this).get(AnimeViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize the adapter
        adapter = AnimeAdapter()
        binding.animeList.layoutManager = LinearLayoutManager(this)
        binding.animeList.adapter = adapter

        fetchAllAnime()

    }

    private fun fetchAllAnime() {
        ///get the list of dev from api response
        animeViewModel.allAnimeList.observe(this,
            Observer<List<Any>>{ animeList ->
                ///if any thing changes the update the UI
                adapter?.setAnimeList(animeList as ArrayList<AnimeItem>)
            })
    }
}