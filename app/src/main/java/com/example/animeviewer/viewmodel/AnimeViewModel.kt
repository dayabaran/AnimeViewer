package com.example.animeviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.animeviewer.DummyDataProvider
import com.example.animeviewer.model.AnimeItem

class AnimeViewModel: ViewModel() {

    var animeList: MutableLiveData<List<AnimeItem>> = MutableLiveData()


    fun getAnimeItems() = DummyDataProvider.getDummyAnime()
}