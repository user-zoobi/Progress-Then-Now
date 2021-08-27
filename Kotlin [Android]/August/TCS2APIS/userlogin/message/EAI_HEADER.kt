package com.example.request.userlogin.message

data class EAI_HEADER (

    var serviceName:String = "oneapp.login",
    var client:String = "TCS",
    var clientChannel:String = "MOB",
    var referenceNum:String = "",
    val securityInfo: SecurityInfo

        )