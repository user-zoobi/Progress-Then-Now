package com.example.retrofitoperations.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class LoginResponse
{
    @SerializedName("status")
    @Expose
    val status = 0

    @SerializedName("message")
    @Expose
    val message: String? = null
}