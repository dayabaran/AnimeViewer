package com.example.animeviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animeviewer.api.RetrofitClient
import com.example.animeviewer.databinding.ActivityMainBinding
import com.example.animeviewer.viewmodel.AnimeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView:RecyclerView

    private val animeViewModel by lazy { ViewModelProvider(this).get(AnimeViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //initialize the adapter
        val adapter = AnimeAdapter()
        binding.animeList.layoutManager = LinearLayoutManager(this)
        binding.animeList.adapter = adapter

        adapter.swapItems(animeViewModel.getAnimeItems())


        RetrofitClient.getAnimeItems("naruto")

       // animeViewModel.getAnimeItems().observe(this, Observer { it?.let { adapter.swapItems(it) } })
    }
}