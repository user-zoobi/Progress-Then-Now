package com.example.retrofitoperations.model

import com.google.gson.annotations.SerializedName

data class Posts(

    @SerializedName("userId") val userId: Int,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String

)