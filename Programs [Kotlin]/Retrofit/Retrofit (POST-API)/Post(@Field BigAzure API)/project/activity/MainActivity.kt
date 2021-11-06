package com.example.retrofitoperations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.example.retrofitoperations.apiService.RetrofitClient
import com.example.retrofitoperations.model.LoginResponse
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //Response on OnClick

        GlobalScope.launch {
            submit_button.setOnClickListener {
                inputs()
            }
        }
    }


    private fun inputs() {

        GlobalScope.launch {


            //Taking inputs form EditText

            val fName = user_fname.text.toString()
            val lName = user_lname.text.toString()
            val gender = user_gender.text.toString()
            val phone = user_phone.text.toString()
            val email = user_email.text.toString()
            val password = user_password.text.toString()
            val dob = user_dob.text.toString()
            val address = user_address.text.toString()

            //Validations For Each Field

            if (TextUtils.isEmpty(fName) || TextUtils.isEmpty(lName) || TextUtils.isEmpty(gender) || TextUtils.isEmpty(phone)
                || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(dob) || TextUtils.isEmpty(address)
            ){
               Log.d("EMPTY", EMPTY_FIELD)
            }

            // Inputs from EditText


            val weService = RetrofitClient.webService.signUpForm(
                fName,lName,gender,"PK","1","L","App",phone,email,password,dob,address,"signup"
            )
            weService.enqueue(object: Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {

                    if (response.isSuccessful){
                        Log.d("SUCCESS", RESPONSE_SUCCESS+" "+ response.body()?.message.toString())
                        Log.d("SUCCESS", RESPONSE_SUCCESS+" "+ response.body()?.status.toString())
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Log.d("FAILED", RESPONSE_FAILED)
                }
            })
        }
    }
}
