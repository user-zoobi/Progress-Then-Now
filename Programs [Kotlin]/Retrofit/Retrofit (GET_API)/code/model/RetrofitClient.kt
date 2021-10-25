package com.example.retrofitoperations.model

import com.example.retrofitoperations.MyService
import com.example.retrofitoperations.MyService.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myService: MyService = retrofit.create(MyService::class.java)
    }
}