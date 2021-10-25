package com.example.retrofitoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitoperations.model.Posts
import com.example.retrofitoperations.model.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        runCode.setOnClickListener {
            apiWebService()
        }
    }

    private fun apiWebService(){

        val webService = RetrofitClient.myService.getPosts()
        webService.enqueue(object :Callback<List<Posts>>{
            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {

                if (response.isSuccessful){
                    for(post:Posts in response.body()!!){
                        showPost(post)
                    }
                }
            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

            }

        })
    }

    private fun showPost(posts: Posts){

        apiText.append("userId"+posts.body+"\n")
        apiText.append("userId"+posts.id+"\n")
        apiText.append("userId"+posts.userId+"\n")
        apiText.append("userId"+posts.title+"\n \n")

    }
}