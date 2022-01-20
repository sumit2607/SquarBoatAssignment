package com.example.squarboatassignment.data.models.Candidate.AvailableJobs


import com.google.gson.annotations.SerializedName

data class AvailableJobData(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)