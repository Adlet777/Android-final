package com.example.myapplication.retrofit

import com.example.myapplication.model.Country
import com.example.myapplication.model.Stats
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRequests {

    @GET("/countries")
    fun getCountries(): Call<List<Country>>

    @GET("/country/{slug}")
    fun getStatsBySlug(@Path("slug") slug: String): Call<List<Stats>>
}