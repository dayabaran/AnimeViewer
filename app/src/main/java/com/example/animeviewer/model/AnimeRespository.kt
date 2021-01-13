package com.example.animeviewer.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animeviewer.AnimeResponse
import com.example.animeviewer.api.RetrofitClient
import com.example.animeviewer.viewmodel.AnimeViewModel
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class AnimeRespository {
    private var mAnimeItemList = ArrayList<AnimeItem>()
    private val mutableLiveData = MutableLiveData<List<AnimeItem>>()

    ////call to internet and  retun  MutableLiveData
    fun getMutableLiveData(): MutableLiveData<List<AnimeItem>> {

        ///ini Retrofit Class
        val userDataService = RetrofitClient.service

        ///call the API that define In Interface
        val call = userDataService.getAnimeItems("naruto")

        call.enqueue(object : Callback<AnimeResponse> {

            override fun onResponse(call: Call<AnimeResponse>, resp: Response<AnimeResponse>) {
                mAnimeItemList = resp.body()?.animeItems as ArrayList<AnimeItem>
                mutableLiveData.value = mAnimeItemList
                Log.d("MYTAG", mAnimeItemList.size.toString())
            }

            override fun onFailure(call: Call<AnimeResponse>, t: Throwable) {
                t.printStackTrace()

            }
        })

        return mutableLiveData
    }

    companion object {

        private val TAG = "AnimeRepository"
    }
}