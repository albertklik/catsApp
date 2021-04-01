package com.klik.catsapp.api

import com.klik.catsapp.BuildConfig
import com.klik.catsapp.models.CatsSearchRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface CatsImageService
{
    @GET("gallery/search/?q=cats")
    fun getCatsImages(@Header("Authorization") clientID: String = BuildConfig.CLIENT_ID) : Call<CatsSearchRequest.Request>
}