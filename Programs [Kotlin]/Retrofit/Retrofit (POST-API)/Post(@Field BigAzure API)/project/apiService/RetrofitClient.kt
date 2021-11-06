package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.apiService.Urls.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        val retrofit by lazy {

            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        }

        val webService by lazy {

            retrofit.create(WebService::class.java)

        }
    }
}