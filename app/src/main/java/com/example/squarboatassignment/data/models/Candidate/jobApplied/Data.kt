package com.example.squarboatassignment.data.models.Candidate.jobApplied


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)