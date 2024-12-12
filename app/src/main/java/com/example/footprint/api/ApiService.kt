package com.example.footprint.api

import com.example.footprint.models.LoginRequestModel
import com.example.footprint.models.RegisterRequestModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("signin")
    fun login(@Body loginRequest: LoginRequestModel): Call<Void>

    @POST("signup")
    fun register(@Body registerRequest: RegisterRequestModel): Call<Void>
}
