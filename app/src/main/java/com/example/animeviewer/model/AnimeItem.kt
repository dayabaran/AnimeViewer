package com.example.animeviewer.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class AnimeItem(

    @SerializedName("mal_id")
    var id:Int? = null,

    @SerializedName("url")
    var url:String? = null,

    @SerializedName("image_url")
    var image_url :String? = null,

    @SerializedName("title")
    var title: String? = null,

    @SerializedName("airing")
    var airing: Boolean? = null,

    @SerializedName("sysnopsis")
    var synopsis : String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("episodes")
    var episodes: Int? = null,

    @SerializedName("score")
    var score:Int? = null,

    @SerializedName("start_date")
    var startDate:Date? = null,

    @SerializedName("end_date")
    var endDate:Date? = null,

    @SerializedName("members")
    var members:Int? = null,

    @SerializedName("rated")
    var rated:String? = null


//    companion object  {
//
//    @BindingAdapter("image_url")
//    fun loadImage(imageView: ImageView, image_url: String) {
//
//        val picasso = Picasso.get()
//        Log.e("imgeurl",image_url)
//
//        picasso.load(image_url)
//            .into(imageView)
//    }
//
//}
)