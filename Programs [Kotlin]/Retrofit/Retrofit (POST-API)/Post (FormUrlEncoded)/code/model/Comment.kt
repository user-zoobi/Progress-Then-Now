package com.example.retrofitoperations.model

import com.google.gson.annotations.SerializedName

data class Comment(

    @SerializedName("postId")
    val postId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: Int,
    @SerializedName("email")
    val email: Int,
    @SerializedName("body")
    val body: Int,

)