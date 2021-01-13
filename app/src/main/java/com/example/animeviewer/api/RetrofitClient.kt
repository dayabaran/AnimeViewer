package com.example.animeviewer.api

import android.util.Log
import com.example.animeviewer.AnimeResponse
import com.example.animeviewer.viewmodel.AnimeViewModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val ANIME = "naruto"
    private var retrofit: Retrofit? = null

    private val service: AnimeApi
    private const val BASE_URL = "https://api.jikan.moe/v3/"

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        service = retrofit.create(AnimeApi::class.java)
    }

    fun getAnimeItems(Anime :String) {
         service.getAnimeItems(Anime).enqueue(object : Callback<AnimeResponse> {
            override fun onResponse(call: Call<AnimeResponse>, response: Response<AnimeResponse>) {
                Log.d("MYTAG", response.body().toString())
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                Log.d("MYTAG", call.request().body.toString())
            }

        })

    }


}