package com.example.mailchimp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.mailchimp.MESSAGE_EMPTY
import com.example.mailchimp.MESSAGE_FAILED
import com.example.mailchimp.MESSAGE_SUCCESS
import com.example.mailchimp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        loginActivity_Button.setOnClickListener {
            userRegistration()
        }
        supportActionBar?.hide()

    }
    private fun userRegistration(){

        val loginEmail = login_emailAddress.text.toString()
        val loginPassword = login_Password.text.toString()

        if (TextUtils.isEmpty(loginEmail) || TextUtils.isEmpty(loginPassword)){
            Toast.makeText(this@LoginActivity, MESSAGE_EMPTY,Toast.LENGTH_SHORT).show()
        }
        else{
            registration(loginEmail, loginPassword)
        }
    }

    private fun registration(email:String, password:String){
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task->
            if (task.isSuccessful){
                Toast.makeText(this@LoginActivity, MESSAGE_SUCCESS,Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@LoginActivity, MESSAGE_FAILED,Toast.LENGTH_SHORT).show()
            }
        }
    }

}