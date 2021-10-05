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
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {

    //Firebase Authentication declaration

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()
        setContentView(R.layout.activity_register)

    //After clicking Email Authentication is generated

        registerActivity_Button.setOnClickListener {
            userRegistration()
        }
        supportActionBar?.hide()
    }

    // User Registration Details Input

    private fun userRegistration(){

        val registrationEmail = register_emailAddress.text.toString()
        val registrationPassword = register_Password.text.toString()

        if (TextUtils.isEmpty(registrationEmail) || TextUtils.isEmpty(registrationPassword)){
            Toast.makeText(this@RegisterActivity, MESSAGE_EMPTY,Toast.LENGTH_SHORT).show()
        }
        else{
            registration(registrationEmail, registrationPassword)
            }
        }

    //Validation for Successful and Failure

    private fun registration(email:String, password:String){
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
            if (task.isSuccessful){
                Toast.makeText(this@RegisterActivity, MESSAGE_SUCCESS,Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this@RegisterActivity, MESSAGE_FAILED,Toast.LENGTH_SHORT).show()
            }
        }
    }

//    private fun detailsIntent(){
//
//    }
}


