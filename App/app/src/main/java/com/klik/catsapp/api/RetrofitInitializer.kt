package com.klik.catsapp.api

import android.os.Build
import com.klik.catsapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer
{
    private val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun catsImageService() = retrofit.create(CatsImageService::class.java)
}