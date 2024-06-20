package com.example.livemessenger.connection_service.signIn

data class signInRequest (
    val token: String,
    val phone_number: String,
    val password: String
)

fun signInRequestParamsToMap(queryParams: signInRequest): Map<String, String> {
    val map = mutableMapOf<String, String>()
    map["token"] = queryParams.token
    map["phone_number"] = queryParams.phone_number
    map["password"] = queryParams.password
    return map
}