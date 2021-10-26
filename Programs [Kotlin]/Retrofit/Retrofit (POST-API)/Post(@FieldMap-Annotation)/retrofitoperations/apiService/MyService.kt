package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.apiService.RetrofitClient.Companion.END_POINT
import com.example.retrofitoperations.model.Posts
import retrofit2.Call
import retrofit2.http.*

interface MyService {

    @FormUrlEncoded
    @POST(END_POINT)
    fun fieldMap(

        @FieldMap
        postsInput: Map<String, String>

    ):Call<Posts>

}