package com.example.squarboatassignment.data.models. Recruiter.Login


import com.google.gson.annotations.SerializedName

data class NewRecruiterLogin(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)