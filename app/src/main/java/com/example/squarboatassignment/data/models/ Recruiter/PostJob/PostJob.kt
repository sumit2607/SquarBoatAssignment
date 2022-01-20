package com.example.squarboatassignment.data.models. Recruiter.PostJob


import com.google.gson.annotations.SerializedName

data class PostJob(
    @SerializedName("code")
    val code: Int,
    @SerializedName("data")
    val `data`: PostJobData,
    @SerializedName("success")
    val success: Boolean
)