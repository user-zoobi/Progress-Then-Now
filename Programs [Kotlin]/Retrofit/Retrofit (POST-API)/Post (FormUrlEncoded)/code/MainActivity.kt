package com.example.retrofitoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitoperations.apiService.MyService
import com.example.retrofitoperations.apiService.RetrofitClient
import com.example.retrofitoperations.model.Comment
import com.example.retrofitoperations.model.Posts
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

//        val post = Posts(3,"hosts","this is post body")
        val call = RetrofitClient.myService.formUrlEncoded(3,"postFormUrl","This is body")
        call.enqueue(object : Callback<Posts>{

            override fun onResponse(call: Call<Posts>, response: Response<Posts>) {
                if (response.isSuccessful){
                    apiText.text = response.code().toString()
                    showPosts(response.body()!!)
                }
            }

            override fun onFailure(call: Call<Posts>, t: Throwable) {

            }
        })
    }

    private fun showPosts(posts: Posts){

       apiText.append("userId : "+ posts.userId+"\n")
       apiText.append("title : "+posts.title+"\n")
       apiText.append("body : "+posts.body+"\n \n")
    }
}