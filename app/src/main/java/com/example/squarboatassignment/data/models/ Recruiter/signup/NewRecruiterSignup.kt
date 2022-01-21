package com.example.squarboatassignment.data.models. Recruiter.signup


import com.google.gson.annotations.SerializedName

data class NewRecruiterSignup(
    @SerializedName("confirmPassword")
    val confirmPassword: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("skills")
    val skills: String,
    @SerializedName("userRole")
    val userRole: Int
)