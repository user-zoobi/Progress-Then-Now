package com.example.retrofitoperations.apiService

import com.example.retrofitoperations.model.Comment
import com.example.retrofitoperations.model.Posts
import retrofit2.Call
import retrofit2.http.*
import kotlin.io.path.ExperimentalPathApi

interface MyService {

    companion object {

        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        const val FEED = "posts"
        const val COMMENTS = "posts/{id}/comments"
    }

    @GET(FEED)
    fun getPosts() : Call<List<Posts>>


    @GET("comments")
    fun getComments(
        @Query("postId") postId:Int
    ) : Call<List<Comment>>


    @POST("posts")
    fun createPost(@Body posts: Posts):Call<Posts>


    @FormUrlEncoded
    @POST("posts")
    fun formUrlEncoded(
        @Field("userId") userId:Int,
        @Field("title") title:String,
        @Field("body") body:String
    ) :Call<Posts>

}