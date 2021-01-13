package com.example.animeviewer.api

import com.example.animeviewer.model.AnimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("search/anime")
    fun getAnimeItems(@Query("q") anime: String): Call<AnimeResponse>

}