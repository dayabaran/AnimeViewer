package com.example.animeviewer.api

import com.example.animeviewer.AnimeResponse
import com.example.animeviewer.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val ANIME = "naruto"

    private val animeApi: AnimeApi
    private const val BASE_URL = "https://api.jikan.moe/v3/"

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        animeApi = retrofit.create(AnimeApi::class.java)
    }

    fun getAnimeItems(): Call<AnimeResponse> {
        return animeApi.getAnimeItems(ANIME)
    }

}