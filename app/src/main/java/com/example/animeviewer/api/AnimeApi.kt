package com.example.animeviewer.api

import com.example.animeviewer.AnimeResponse
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import org.json.JSONArray
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApi {

    @GET("search/anime")
    fun getAnimeItems(@Query("q") anime: String): Call<AnimeResponse>


//    @GET("search/anime")
//    fun searchMovie(@Query("q") api_key: String, @Query("query") q: String): Call<AnimeResponse>
}