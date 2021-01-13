package com.example.animeviewer.model

import com.example.animeviewer.model.AnimeItem
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Describes the response from Anime  API.
 */
 class AnimeResponse(
   @SerializedName("request_hash")
    @Expose
    val requestHash: String = "",

   @SerializedName("request_cached")
    @Expose
    val isRequestCached: Boolean = false,

   @SerializedName("request_cache_expiry")
    @Expose
    val requestCacheExpiry: Int = 0,

   @SerializedName("results")
    @Expose
    val animeItems: List<AnimeItem> = emptyList(),

   @SerializedName("last_page")
    @Expose
    val lastPage:Int = 0
)