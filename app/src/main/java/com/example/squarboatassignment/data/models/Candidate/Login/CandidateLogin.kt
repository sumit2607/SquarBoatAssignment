package com.example.squarboatassignment.data.models.Candidate.Login


import com.google.gson.annotations.SerializedName

data class CandidateLogin(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)