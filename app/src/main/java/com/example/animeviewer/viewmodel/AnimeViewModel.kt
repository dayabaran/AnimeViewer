package com.example.animeviewer.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animeviewer.model.AnimeItem
import com.example.animeviewer.model.AnimeRespository

class AnimeViewModel(application: Application): AndroidViewModel(application) {
    private val animeRespository: AnimeRespository

    val allAnimeList: MutableLiveData<List<AnimeItem>>
        get() = animeRespository.getMutableLiveData()

    init {
        animeRespository = AnimeRespository()
    }
}