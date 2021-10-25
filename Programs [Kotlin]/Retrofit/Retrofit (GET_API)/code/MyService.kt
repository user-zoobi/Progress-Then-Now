package com.example.retrofitoperations

import com.example.retrofitoperations.model.Posts
import retrofit2.Call
import retrofit2.http.GET

interface MyService {

    companion object {

        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val FEED = "posts"
    }

    @GET(FEED)
    fun getPosts() : Call<List<Posts>>
}