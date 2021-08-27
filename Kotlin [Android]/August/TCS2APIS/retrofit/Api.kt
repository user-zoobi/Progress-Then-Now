package com.example.request.retrofit

import com.example.request.userlogin.Object
import com.example.request.authentication.Object_AUTH
import com.example.request.retrofit.Url.Companion.BASE_URL
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST(BASE_URL)
    suspend fun getPost(@Body requestBody: JsonObject):Response<Object>

    @POST(BASE_URL)
    suspend fun getAuthentication(@Body requestBody: JsonObject):Response<Object_AUTH>
}