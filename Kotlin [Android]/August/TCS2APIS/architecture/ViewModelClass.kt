package com.example.request.architecture

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.request.authentication.Object_AUTH
import com.example.request.userlogin.Object
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class ViewModelClass(private val repository: Repository): ViewModel() {

    val mResponse:MutableLiveData<Response<Object>> = MutableLiveData()

    val mResponseAuthentication:MutableLiveData<Response<Object_AUTH>> = MutableLiveData()

    fun getPosts(requestBody: JsonObject) {

        viewModelScope.launch {
          val response =  repository.getPosts(requestBody)
            mResponse.value = response

        }
    }

    fun getAuthentication(requestBody: JsonObject) {

        viewModelScope.launch {
            val response =  repository.getAuthentication(requestBody)
            mResponseAuthentication.value = response

        }
    }
}