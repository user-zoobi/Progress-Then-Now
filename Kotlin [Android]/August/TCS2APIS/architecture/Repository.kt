package com.example.request.architecture

import com.example.request.authentication.Object_AUTH
import com.example.request.retrofit.RetrofitInstance
import com.example.request.userlogin.Object
import com.google.gson.JsonObject
import retrofit2.Response

class Repository {

    suspend fun getPosts(requestBody: JsonObject):Response<Object> {
        return RetrofitInstance.api.getPost(requestBody)
    }

    suspend fun getAuthentication(requestBody: JsonObject):Response<Object_AUTH> {
        return RetrofitInstance.api.getAuthentication(requestBody)
    }
}