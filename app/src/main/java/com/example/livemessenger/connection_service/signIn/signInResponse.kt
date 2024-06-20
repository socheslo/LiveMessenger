package com.example.livemessenger.connection_service.signIn

data class signInResponse(
    val token: String,
    val phone_number: String,
    val password: String
)


