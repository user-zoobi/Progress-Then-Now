package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.apiService.MyService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myService = retrofit.create(MyService::class.java)
    }
}