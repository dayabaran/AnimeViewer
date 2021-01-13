package com.example.animeviewer.viewmodel

import androidx.lifecycle.ViewModel
import com.example.animeviewer.DummyDataProvider

class AnimeViewModel: ViewModel() {

    fun getAnimeItems() = DummyDataProvider.getDummyAnime()
}