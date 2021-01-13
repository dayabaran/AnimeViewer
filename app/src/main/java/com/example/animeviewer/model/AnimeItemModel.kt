package com.example.animeviewer.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class AnimeItemModel(

    @SerializedName("mal_id")
    var id:Int,

    @SerializedName("url")
    var url:String,

    @SerializedName("image_url")
    var imageUrl :String,

    @SerializedName("title")
    var title: String,

    @SerializedName("airing")
    var airing: Boolean,

    @SerializedName("sysnopsis")
    var synopsis : String,

    @SerializedName("type")
    var type: String,

    @SerializedName("episodes")
    var episodes: Int,

    @SerializedName("score")
    var score:Int,

    @SerializedName("start_date")
    var startDate:Date,

    @SerializedName("end_date")
    var endDate:Date,

    @SerializedName("members")
    var members:Int,

    @SerializedName("rated")
    var rated:String
)