package com.example.squarboatassignment.data.models.Candidate.Signup


import com.google.gson.annotations.SerializedName

data class CandidateSignup(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)