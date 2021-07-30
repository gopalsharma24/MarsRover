package com.example.mars.network

import com.example.mars.model.Photos
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL="https://api.nasa.gov/"
const val API_KEY = "wcTOY2sexbX7fTd9P6MYLokN6f94agAP5YoGaM7y"

interface RetroInterface {

    @GET("mars-photos/api/v1/rovers/curiosity/photos?api_key=$API_KEY")//mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
    fun getAPIData(@Query("sol") sol: Int):Call<Photos>
}

object RetroService{
    val retroInstance: RetroInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retroInstance = retrofit.create(RetroInterface::class.java)
    }
}