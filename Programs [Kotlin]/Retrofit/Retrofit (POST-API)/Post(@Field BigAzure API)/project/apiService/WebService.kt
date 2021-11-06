package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.apiService.Urls.Companion.ENDPOINT
import com.example.retrofitoperations.model.LoginResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface WebService {

    @FormUrlEncoded
    @POST(ENDPOINT)
    fun signUpForm(
        @Field("fname") fname:String,
        @Field("lname") lname:String,
        @Field("gender") gender:String,
        @Field("country") country:String,
        @Field("city") city:String,
        @Field("type") type:String,
        @Field("channel") channel:String,
        @Field("phone") phone:String,
        @Field("email") email:String,
        @Field("password") password:String,
        @Field("dob") dob:String,
        @Field("address") address:String,
        @Field("action") action:String,
    ): Call<LoginResponse>
}