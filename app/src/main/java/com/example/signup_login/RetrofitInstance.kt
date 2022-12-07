package com.example.signup_login

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val baseUrl = "https://gorest.co.in/public/v2/"
      fun getRetrofit():Retrofit{

          val logging = HttpLoggingInterceptor()
          logging.level = (HttpLoggingInterceptor.Level.BODY)
          val client = OkHttpClient.Builder()
          client.addInterceptor(logging)

          return Retrofit.Builder()
              .baseUrl(baseUrl)
              .client(client.build())
              .addConverterFactory(GsonConverterFactory.create())
              .build()
     }
}