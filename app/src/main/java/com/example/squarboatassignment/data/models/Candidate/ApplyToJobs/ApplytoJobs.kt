package com.example.squarboatassignment.data.models.Candidate.ApplyToJobs


import com.google.gson.annotations.SerializedName

data class ApplytoJobs(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("success")
    val success: Boolean
)