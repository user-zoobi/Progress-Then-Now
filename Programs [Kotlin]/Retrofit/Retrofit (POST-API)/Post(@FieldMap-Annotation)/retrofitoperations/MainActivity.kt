package com.example.retrofitoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitoperations.apiService.RetrofitClient
import com.example.retrofitoperations.model.Posts
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val postsInput = HashMap<String,String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        //onClick Request
        runCode.setOnClickListener {
            webService()
        }
    }

    private fun webService(){

        postsInput["userId"] = "33"
        postsInput["title"] = "fieldMap"
        postsInput["body"] = "this is fieldMap body"

        val webService = RetrofitClient.myWebService.fieldMap(postsInput)

        webService.enqueue(object : Callback<Posts>{

            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful){
                   apiText.text = response.code().toString()
                   showPost(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {

            }
        })
    }

    private fun showPost(posts: Posts){

        apiText.append("\n"+"userId : "+posts.userId+"\n")
        apiText.append("body : "+posts.body+"\n")
        apiText.append("title : "+posts.title+"\n \n")

    }
}