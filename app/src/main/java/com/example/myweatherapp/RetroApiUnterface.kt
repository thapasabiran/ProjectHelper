package com.example.myfirstretrofit

import com.example.myweatherapp.Weather
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface RetroApiInterface {
    //Singleton
    @GET("current.json?q=London&key=717d5fe93e284ffbb6022313220606")
    suspend fun getCurrentWeather(): Response<Weather>

//    @POST("posts")
//    suspend fun createBooks(@Body requestBody: RequestBody): Response<ResponseBody>

    companion object {
        var BASE_URL = "https://api.weatherapi.com/v1/"
        fun create(): RetroApiInterface {
//            val httpClient = OkHttpClient.Builder()
//            httpClient.addInterceptor { chain ->
//
//                val original = chain.request()
//
//                // Request customization: add request headers
//                val requestBuilder = original.newBuilder()
//                    .header("key", "717d5fe93e284ffbb6022313220606") // <-- this is the important line
//
//                val request = requestBuilder.build()
//                chain.proceed(request)
//
////                val original: Request = chain.request()
////                val originalHttpUrl: HttpUrl = original.url
////                val url = originalHttpUrl.newBuilder()
////                    .addQueryParameter("Key", "717d5fe93e284ffbb6022313220606")
////                    .build()
////
////                // Request customization: add request headers
////                val requestBuilder: Request.Builder = original.newBuilder()
////                    .url(url)
////                val request: Request = requestBuilder.build()
////                chain.proceed(request)
//            }
//
//            val okHttpClient = httpClient.build()

            val retrofit =
                Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
//                    .client(okHttpClient)
                    .build()
            return retrofit.create(RetroApiInterface::class.java)
        }
    }
}