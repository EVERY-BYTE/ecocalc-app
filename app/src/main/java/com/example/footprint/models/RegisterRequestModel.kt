package com.example.footprint.models

data class RegisterRequestModel(
    val userName: String,
    val email: String,
    val password: String,
    val confirmPassword: String
)
