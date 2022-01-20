package com.example.squarboatassignment.data.models. Recruiter.signup


import com.google.gson.annotations.SerializedName

data class RecruiterSignup(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)