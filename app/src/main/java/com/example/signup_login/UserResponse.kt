package com.example.signup_login


data class UserResponse(
    val code : Int,
    val meta : String,
    val data: User
)