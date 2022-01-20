package com.example.squarboatassignment.data.models.Candidate.AvailableJobs


import com.google.gson.annotations.SerializedName

data class Metadata(
    @SerializedName("count")
    val count: Int,
    @SerializedName("limit")
    val limit: String
)