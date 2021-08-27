package com.example.request.authentication

import com.example.request.authentication.body.EAI_BODY_AUTH
import com.example.request.authentication.message.EAI_MESSAGE_AUTH

data class Object_AUTH (

    val eaiBodyAuth: EAI_BODY_AUTH,
    val eaiMessageAuth: EAI_MESSAGE_AUTH

        )