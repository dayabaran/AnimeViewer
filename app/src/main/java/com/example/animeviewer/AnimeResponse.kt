package com.example.animeviewer

import com.example.animeviewer.model.AnimeItem
import com.google.gson.annotations.SerializedName

/**
 * Describes the response from Anime  API.
 */
data class AnimeResponse(
    @SerializedName("request_hash")
    val requestHash: String = "",

    @SerializedName("request_cached")
    val isRequestCached: Boolean = false,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int = 0,

    @SerializedName("results")
    val animeItems: List<AnimeItem> = emptyList()
)