package com.example.request.userlogin

import com.example.request.userlogin.login.EAI_BODY
import com.example.request.userlogin.message.EAI_MESSAGE

data class Object (

    val eaiMessage: EAI_MESSAGE,
    val eaiBody: EAI_BODY

        )