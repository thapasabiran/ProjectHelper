package com.example.myweatherapp

import com.example.myfirstretrofit.RetroApiInterface
import okhttp3.RequestBody

class Repository (private val inter: RetroApiInterface) {
    suspend fun getCurrentWeather() = inter.getCurrentWeather()

//    suspend fun postBook(requestBody: RequestBody) = inter.getCurrentWeather(requestBody)
}