package com.example.squarboatassignment.data.models. Recruiter.passwordChange


import com.google.gson.annotations.SerializedName

data class PasswordChange(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Boolean
)