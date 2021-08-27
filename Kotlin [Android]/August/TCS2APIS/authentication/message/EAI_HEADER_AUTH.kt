package com.example.request.authentication.message

data class EAI_HEADER_AUTH (

    var serviceName:String = "oneapp.pinvalidate",
    var client:String = "TCS",
    var clientChannel:String = "MOB",
    var referenceNum:String = "",
    var securityinfoAuth: SecurityInfo_AUTH

        )