package com.example.squarboatassignment.data.models. Recruiter.Login


import com.google.gson.annotations.SerializedName

data class RecruiterLogin(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: LoginData,
    @SerializedName("success")
    val success: Boolean
)