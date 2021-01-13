package com.example.animeviewer.api

import android.util.Log
import com.example.animeviewer.model.AnimeResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var retrofit: Retrofit? = null

    private const val BASE_URL = "https://api.jikan.moe/v3/"
     val service: AnimeApi
        get() {
            val builder = OkHttpClient.Builder()
            val okHttpClient = builder.build()
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }

            return retrofit!!.create(AnimeApi::class.java!!)
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