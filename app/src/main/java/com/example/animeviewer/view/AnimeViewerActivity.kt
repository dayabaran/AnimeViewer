package com.example.animeviewer.view

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeviewer.R
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
        handleIntent(intent)

        fetchAllAnime()

    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleIntent(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        (menu.findItem(R.id.search).actionView as SearchView).apply {
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }

        return true
    }

    private fun handleIntent(intent: Intent) {

        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            //use the query to search your data somehow
            Log.d("MYTAG", "handleIntent: $query")
        }
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