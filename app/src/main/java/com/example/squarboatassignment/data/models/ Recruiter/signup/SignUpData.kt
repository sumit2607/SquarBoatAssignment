package com.example.squarboatassignment.data.models. Recruiter.signup


import com.google.gson.annotations.SerializedName

data class SignUpData(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("skills")
    val skills: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("updatedAt")
    val updatedAt: String,
    @SerializedName("userRole")
    val userRole: Int
)