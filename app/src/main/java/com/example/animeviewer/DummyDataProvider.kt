package com.example.animeviewer

import com.example.animeviewer.model.NewsArticle

object DummyDataProvider {

    fun getDummyAnime() = listOf(
        NewsArticle("Android Architecture", "Android Architecture Components"),
        NewsArticle("Kotlin", "Official programming language for Android"),
        NewsArticle("Food", "I am a foodie")
    )

}