package com.example.animeviewer.model

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

class AnimeItem {
    @SerializedName("mal_id")
    @Expose
    var malId: Int? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("image_url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("airing")
    @Expose
    var airing: Boolean? = null

    @SerializedName("synopsis")
    @Expose
    var synopsis: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("episodes")
    @Expose
    var episodes: Int? = null

    @SerializedName("score")
    @Expose
    var score: Float? = null

    @SerializedName("start_date")
    @Expose
    var startDate: String? = null

    @SerializedName("end_date")
    @Expose
    var endDate: String? = null

    @SerializedName("members")
    @Expose
    var members: Int? = null

    @SerializedName("rated")
    @Expose
    var rated: String? = null

    companion object  {


        @JvmStatic
        @BindingAdapter("image_url")
        fun loadImage(imageView: ImageView, imageURL: String) {

            Log.e("imgeurl",imageURL)
            val picasso = Picasso.get()
            picasso.load(imageURL).into(imageView)
        }

    }
}