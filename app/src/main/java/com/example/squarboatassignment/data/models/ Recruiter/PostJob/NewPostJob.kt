package com.example.squarboatassignment.data.models. Recruiter.PostJob


import com.google.gson.annotations.SerializedName

data class NewPostJob(
    @SerializedName("description")
    val description: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String
)