package com.example.squarboatassignment.data.models. Recruiter.ForgetPassword


import com.google.gson.annotations.SerializedName

data class NewForgetPasword(
    @SerializedName("confirmPassword")
    val confirmPassword: String,
    @SerializedName("password")
    val password: String
)