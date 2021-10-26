package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.apiService.RetrofitClient.Companion.END_POINT
import com.example.retrofitoperations.model.Posts
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyService {

    @POST(END_POINT)
    fun createBodyPost(@Body posts: Posts) : Call<Posts>

}