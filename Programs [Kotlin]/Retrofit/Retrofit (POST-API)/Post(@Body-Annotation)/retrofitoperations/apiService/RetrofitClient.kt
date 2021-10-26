package com.example.retrofitoperations.apiService

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object{

        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val END_POINT = "posts"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val myWebService = retrofit.create(MyService::class.java)
    }

}