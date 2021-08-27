package com.example.request

//25 -27 August,21
//PostUrl Request

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.request.architecture.Repository
import com.example.request.architecture.ViewModelClass
import com.example.request.architecture.ViewModelFactory
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // IMPLEMENTING MEMBERS

        val repository = Repository()
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(ViewModelClass::class.java)


        //CALLING RESPONSE METHODS

        loginJsonResponse()
        loginJsonToString()


 //*_________________________________________________________________________________________________*//
    // *_________________________________________________________________________________________________*//

    }

    private fun loginJsonResponse() {

        //CHECKING RESPONSE

        viewModel.mResponse.observe(this, Observer { response ->

            if (response.isSuccessful) {
                Log.d("RESPONSE", response.toString())
            }

            else {
                Toast.makeText(this, "Response Not Found", Toast.LENGTH_SHORT)
            }
        })
    }


    private fun loginJsonToString() {

        button.setOnClickListener {

            if (employeeNo.text.toString() == "5852") {

                //BODY JSON

                val userInfo = JSONObject()
                userInfo.put("employeeno", employeeNo)
                userInfo.put("applicationId", "1")
                userInfo.put("deviceid", "1")
                val eaiRequest = JSONObject()
                eaiRequest.put("userInfo", userInfo)
                val eaiBody = JSONObject()
                eaiBody.put("eaiRequest", eaiRequest)

                //MESSAGE JSON

                val authentication = JSONObject()
                authentication.put("userId", "")
                authentication.put("password", "")
                val securityInfo = JSONObject()
                securityInfo.put("authentication", authentication)
                val eaiHeader = JSONObject()
                eaiHeader.put("servicename", "oneapp.login")
                eaiHeader.put("client", "TCS")
                eaiHeader.put("clientchannel", "MOB")
                eaiHeader.put("referenceNum", "")
                eaiHeader.put("securityInfo", securityInfo)
                val eaiMessage = JSONObject()
                eaiMessage.put("eaiMessage", eaiHeader)

                //FINAL JSON

                val objectJson = JSONObject()
                objectJson.put("eaiMessage", eaiMessage)
                objectJson.put("eaiBody", eaiBody)

                //CONVERSION INTO STRING

                val objectString = objectJson.toString()
                val jsonParser = JsonParser()
                val data = jsonParser.parse(objectString) as JsonObject

                //SENDING DATA TO THE OBJECT
                viewModel.getPosts(data)
            }

            else {
                Toast.makeText(this, "Enter EmployeeNo Again", Toast.LENGTH_SHORT)
            }
            authenticationJsonResponse()
            authenticationJson()
        }
    }

    private fun authenticationJsonResponse(){

        viewModel.mResponseAuthentication.observe(this, Observer { response->

            if(response.isSuccessful){
                Log.d("RESPONSE AUTH", response.toString())
            }
            else{
                Toast.makeText(this, "Response Not Found", Toast.LENGTH_SHORT)
            }
        })
    }
   private fun authenticationJson(){
        if(employeeNo.text.toString() == "5852"){

            //BODY JSON
            val userInfo = JSONObject()
            userInfo.put("employeeno", employeeNo)
            userInfo.put("pincode", "877233")

            userInfo.put("firebasetoken", "d5vGFJCdR0KBg0iuaRskGH:APA91bGs2ZWv" +
                    "-fYe3y4ZkxsYxA_uql7olKFAHfaKRvMxeiufqJk2WuZbDMTQkdne7L0pVfDybO_lOhnN1yT6SxlHUa0SIFyu3D6VhmtBGlWkoV1ZuMF" +
                    "_UaOKJxXMaocE6ZghkiZgZs2y")

            userInfo.put("applicationid", "1")
            val eaiRequest = JSONObject()
            eaiRequest.put("userInfo", userInfo)
            val eaiBody = JSONObject()
            eaiBody.put("eaiRequest", eaiRequest)

           // MESSAGE JSON
            val authentication = JSONObject()
            authentication.put("userId", "")
            authentication.put("password", "")
            val securityInfo = JSONObject()
            securityInfo.put("authentication", authentication)
            val eaiHeader = JSONObject()
            eaiHeader.put("servicename", "oneapp.pinvalidate")
            eaiHeader.put("client", "TCS")
            eaiHeader.put("clientchannel", "MOB")
            eaiHeader.put("referenceNum", "")
            eaiHeader.put("securityInfo", securityInfo)
            val eaiMessage = JSONObject()
            eaiMessage.put("eaiMessage", eaiHeader)

            //FINAL JSON

            val objectJsonAuth = JSONObject()
            objectJsonAuth.put("eaiMessage", eaiMessage)
            objectJsonAuth.put("eaiBody", eaiBody)

            //CONVERSION INTO STRING

            val objectString = objectJsonAuth.toString()
            val jsonParser = JsonParser()
            val dataAuth = jsonParser.parse(objectString) as JsonObject

            //SENDING DATA TO THE OBJECT
            viewModel.getAuthentication(dataAuth)

        }
    }
}

