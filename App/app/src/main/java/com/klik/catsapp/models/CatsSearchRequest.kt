package com.klik.catsapp.models

import com.google.gson.annotations.SerializedName

object CatsSearchRequest {
    data class Request(@SerializedName("data") val data: List<CatsImage>)
    data class CatsImage (@SerializedName("cover") val coverId: String,
                          @SerializedName("title") val title: String)
    {
         fun getCoverUrl() = "https://i.imgur.com/" + coverId + ".jpg"
    }
}