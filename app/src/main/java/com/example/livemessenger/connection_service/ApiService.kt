package com.example.livemessenger.connection_service
import com.example.livemessenger.connection_service.signIn.signInResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("api/SignIn")
    fun signIn(@QueryMap options: Map<String, String>): Call<signInResponse>
}