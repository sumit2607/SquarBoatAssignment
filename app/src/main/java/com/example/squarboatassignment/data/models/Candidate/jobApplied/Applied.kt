package com.example.squarboatassignment.data.models.Candidate.jobApplied


import com.google.gson.annotations.SerializedName

data class Applied(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)